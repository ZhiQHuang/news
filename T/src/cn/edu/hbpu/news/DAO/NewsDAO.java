package cn.edu.hbpu.news.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.edu.hbpu.news.Util.DBCPUtils;
import cn.edu.hbpu.news.model.News;

public class NewsDAO {
	QueryRunner runner=new QueryRunner(DBCPUtils.getDataSource());
	
	public int insert(News news) {
		int result=0;
		//Connection conn=DBManager.getConn();
		String sql="insert into news(classId,headTitle,content,author,"+
		"editor,newsFrom,top,newsTime,hits,state,isDel,pictures)"+"values(?,?,?,?,?,?,?,now(),?,?,?,?)";
		
		try {
			result=runner.update(sql,news.getClassId(),
					news.getHeadTitle(),news.getContent(),
					news.getAuthor(),news.getEditor(),news.getNewsFrom(),
					news.getTop(),0,"未审核",0,news.getPictures());
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		/*finally{
			DBManager.close(conn);
		}*/
		return result;
	}
	
	public int update(News news) {
		int result=0;
		String sql="update news set classId=?,headTitle=?,content=?,author=?,"+
		"editor=?,newsFrom=?,top=?,pictures=? where newsId=?";
		
		try {
			result=runner.update(sql,news.getClassId(),
					news.getHeadTitle(),news.getContent(),
					news.getAuthor(),news.getEditor(),
					news.getNewsFrom(),news.getTop(),
					news.getPictures(),news.getNewsId());
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	public int update1(News news) {
		int result=0;
		String sql="update news set state='已审核' where newsId=?";
		
		try {
			result=runner.update(sql,news.getNewsId());
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	/*public List<News> getList(){
		List<News> list=new ArrayList<News>();
		//Connection conn=DBManager.getConn();
		String sql="select * from news where isDel=0 "
			+"order by newsId asc";
		BeanListHandler<News> bh
		=new BeanListHandler<News>(News.class);
		//因为返回结果是List集合，所以使用BeanListHandler
		//而不使用BeanHandler（代表返回结果为单个对象）
		try {
			list=runner.query(conn,sql,bh);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}*/
	public int getTotalRecordNum(){
		Long num=null;
		String sql="select count(*) from news where isDel=0 ";
		try {
			Object obj=runner.query(sql, new ScalarHandler());
			num=(Long)obj;
			return num.intValue();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<News> getListByPage(int startIndex,int pageSize){
		List<News> list=new ArrayList<News>();
		//Connection conn=DBManager.getConn();
		String sql="select * from news where isDel=0 "
			+"order by newsId desc limit ?,?";
		BeanListHandler<News> bh
		=new BeanListHandler<News>(News.class);
		//因为返回结果是List集合，所以使用BeanListHandler，
		//而不使用BeanHandler（代表返回结果为单个对象）
		try {
			list=runner.query(/*conn,*/sql,bh,startIndex,pageSize);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public News getNewsById(String newsId){
		News news=new News();
		String sql="select*from news where isDel=0 and newsId=?";
		try {
			news=runner.query(sql,new BeanHandler<News>(News.class),newsId);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return news;
	}

	public int delete(String newsId) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="update news set isDel=1 where newsId=?";
		
		try {
			result=runner.update(sql,newsId);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	//新闻表中最近的已审核的头条新闻
	public News getTopNews(){
		News news=new News();
		String sql="select*from news where isDel=0 and "+
				"top=1 and state='已审核' order by newsId desc";
		try {
			news=runner.query(sql,new BeanListHandler<News>(News.class)).get(0);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return news;
	}
	
	//新闻表中最近的已审核的number条新闻
	public List<News> getRecentNews(int number){
		List<News> newsList=new ArrayList<News>();
		String sql="select*from news where isDel=0 "+
				"and state='已审核' order by newsId desc limit ?";
		try {
			newsList=runner.query(sql,new BeanListHandler<News>(News.class),number);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return newsList;
	}
	
	
	//新闻表中对应classId新闻分类的已审核的number条新闻
	public List<News> getNewsByClassId(int number,int classId){
		List<News> newsList=new ArrayList<News>();
		String sql="select n.*,c.content as className from news n "+
				"left join newsclass c on n.classId=c.classId "+
				"where n.isDel=0 and state='已审核' and n.classId=? "+
				"order by newsId desc limit ?";
		try {
			newsList=runner.query(sql,new BeanListHandler<News>(News.class),
					classId,number);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return newsList;
	}
	
	
	//得到startIndex开始的pageSize个已审核未删除的记录
	public List<News> getVerifiedListByPage(int startIndex,int pageSize){
		List<News> list=new ArrayList<News>();
		String sql="select * from news where isDel=0 and state='已审核' "+
				"order by newsId desc limit ?,?";
		BeanListHandler<News> bh
			=new BeanListHandler<News>(News.class);
		try {
			list=runner.query(sql,bh,startIndex,pageSize);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	
	//news表已审核未删除的记录总数
	public int getVerifiedTotalRecordNum(){
		Long num=null;
		String sql="select count(*) from news where isDel=0 and state='已审核' ";
		try {
			Object obj=runner.query(sql,new ScalarHandler());
			num=(Long)obj;
			return num.intValue();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	
	//分页获取新闻表中对应classId新闻分类的已审核的新闻
	public List<News> getNewsByClassId(String classId,int StartIndex,int pageSize){
		List<News> newsList=new ArrayList<News>();
		String sql="select n.*,c.content as className from news n "+
				"left join newsclass c on n.classId=c.classId "+
				"where n.isDel=0 and state='已审核' and n.classId=? "+
				"order by newsId desc limit ?,?";
		try {
			newsList=runner.query(sql,new BeanListHandler<News>(News.class),
					classId,StartIndex,pageSize);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return newsList;
	}
	
	
	//news表对应classId新闻分类的记录总数
	public int getTotalRecordNumByClassId(String classId){
		Long num=null;
		String sql="select count(*) from news where isDel=0 and state='已审核' "+
				"and classId=? ";
		try {
			Object obj=runner.query(sql,new ScalarHandler(),classId);
			num=(Long)obj;
			return num.intValue();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	
	//分页获取新闻表中对应title的已审核的新闻
	public List<News> getNewsByTitle(String title,int StartIndex,int pageSize){
		List<News> newsList=new ArrayList<News>();
		String sql="select n.*,c.content as className from news n "+
				"left join newsclass c on n.classId=c.classId "+
				"where n.isDel=0 and state='已审核' and n.headTitle like ? "+
				"order by newsId desc limit ?,?";
		try {
			newsList=runner.query(sql,new BeanListHandler<News>(News.class),
					"%"+title+"%",StartIndex,pageSize);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return newsList;
	}
	
	
	//news表对应title的记录总数
	public int getTotalRecordNumByTitle(String title){
		Long num=null;
		String sql="select count(*) from news where isDel=0 and state='已审核' "+
				"and headTitle like ? ";
		try {
			Object obj=runner.query(sql,new ScalarHandler(),"%"+title+"%");
			num=(Long)obj;
			return num.intValue();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	
	//根据新闻的newsId获取新闻的全部内容
	public News getVerifiedNewsById(String newsId){
		News news=new News();
		String sql="select n.*,c.content as className from news n "+
		"left join newsclass c on n.classId=c.classId "+
		"where n.isDel=0 and state='已审核' and n.newsId=? ";
		try {
			news=runner.query(sql,new BeanHandler<News>(News.class),newsId);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    	return news;
	}
	
	
	//修改新闻的点击率
	public int updateHits(News news){
		int result=0;
		String sql="update news set hits=? where newsId=?";
		try {
			result=runner.update(sql,news.getHits(),news.getNewsId());
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result ;
	}

}
