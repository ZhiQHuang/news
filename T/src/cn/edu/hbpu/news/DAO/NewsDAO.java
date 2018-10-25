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
					news.getTop(),0,"δ���",0,news.getPictures());
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
		String sql="update news set state='�����' where newsId=?";
		
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
		//��Ϊ���ؽ����List���ϣ�����ʹ��BeanListHandler
		//����ʹ��BeanHandler�������ؽ��Ϊ��������
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
		//��Ϊ���ؽ����List���ϣ�����ʹ��BeanListHandler��
		//����ʹ��BeanHandler�������ؽ��Ϊ��������
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
	
	//���ű������������˵�ͷ������
	public News getTopNews(){
		News news=new News();
		String sql="select*from news where isDel=0 and "+
				"top=1 and state='�����' order by newsId desc";
		try {
			news=runner.query(sql,new BeanListHandler<News>(News.class)).get(0);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return news;
	}
	
	//���ű������������˵�number������
	public List<News> getRecentNews(int number){
		List<News> newsList=new ArrayList<News>();
		String sql="select*from news where isDel=0 "+
				"and state='�����' order by newsId desc limit ?";
		try {
			newsList=runner.query(sql,new BeanListHandler<News>(News.class),number);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return newsList;
	}
	
	
	//���ű��ж�ӦclassId���ŷ��������˵�number������
	public List<News> getNewsByClassId(int number,int classId){
		List<News> newsList=new ArrayList<News>();
		String sql="select n.*,c.content as className from news n "+
				"left join newsclass c on n.classId=c.classId "+
				"where n.isDel=0 and state='�����' and n.classId=? "+
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
	
	
	//�õ�startIndex��ʼ��pageSize�������δɾ���ļ�¼
	public List<News> getVerifiedListByPage(int startIndex,int pageSize){
		List<News> list=new ArrayList<News>();
		String sql="select * from news where isDel=0 and state='�����' "+
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
	
	
	//news�������δɾ���ļ�¼����
	public int getVerifiedTotalRecordNum(){
		Long num=null;
		String sql="select count(*) from news where isDel=0 and state='�����' ";
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
	
	
	//��ҳ��ȡ���ű��ж�ӦclassId���ŷ��������˵�����
	public List<News> getNewsByClassId(String classId,int StartIndex,int pageSize){
		List<News> newsList=new ArrayList<News>();
		String sql="select n.*,c.content as className from news n "+
				"left join newsclass c on n.classId=c.classId "+
				"where n.isDel=0 and state='�����' and n.classId=? "+
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
	
	
	//news���ӦclassId���ŷ���ļ�¼����
	public int getTotalRecordNumByClassId(String classId){
		Long num=null;
		String sql="select count(*) from news where isDel=0 and state='�����' "+
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
	
	
	//��ҳ��ȡ���ű��ж�Ӧtitle������˵�����
	public List<News> getNewsByTitle(String title,int StartIndex,int pageSize){
		List<News> newsList=new ArrayList<News>();
		String sql="select n.*,c.content as className from news n "+
				"left join newsclass c on n.classId=c.classId "+
				"where n.isDel=0 and state='�����' and n.headTitle like ? "+
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
	
	
	//news���Ӧtitle�ļ�¼����
	public int getTotalRecordNumByTitle(String title){
		Long num=null;
		String sql="select count(*) from news where isDel=0 and state='�����' "+
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
	
	
	//�������ŵ�newsId��ȡ���ŵ�ȫ������
	public News getVerifiedNewsById(String newsId){
		News news=new News();
		String sql="select n.*,c.content as className from news n "+
		"left join newsclass c on n.classId=c.classId "+
		"where n.isDel=0 and state='�����' and n.newsId=? ";
		try {
			news=runner.query(sql,new BeanHandler<News>(News.class),newsId);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	    	return news;
	}
	
	
	//�޸����ŵĵ����
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
