package cn.edu.hbpu.news.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.edu.hbpu.news.Util.DBCPUtils;
import cn.edu.hbpu.news.model.NewsClass;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class NewsClassDAO {
	QueryRunner runner=new QueryRunner(DBCPUtils.getDataSource());
	//return newsclass表中所有新闻分类的信息
	public List<NewsClass> getList(){
		List<NewsClass> list=new ArrayList<NewsClass >();
		//Connection conn=DBManager.getConn();
		String sql="select * from newsclass where isDel=0 "
			+"order by classId asc";
		BeanListHandler<NewsClass> bh
		=new BeanListHandler<NewsClass>(NewsClass.class);
		//因为返回结果是List集合，所以使用BeanListHandler，
		//而不使用BeanHandler（代表返回结果为单个对象）
		try {
			list=runner.query(/*conn,*/sql,bh);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	
	 public int getTotalRecordNum(){
			Long num=null;
			String sql="select count(*) from newsclass where isDel=0 ";
			 try {
				 Object obj=runner.query(sql, new ScalarHandler());
				 num=(Long)obj;
				 return num.intValue();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return 0;
			
		}
	 
	 
	 public List<NewsClass> getListByPage(int startIndex,int PageSize){
			List<NewsClass> list= new ArrayList<NewsClass>();
			String sql="select * from newsclass where isDel=0 "+"and type=1 "
			+"order by  classId asc limit ?,?";
			 BeanListHandler<NewsClass> bh=
		     new BeanListHandler<NewsClass>(NewsClass.class);
			  try {
					list=runner.query(sql,bh,startIndex,PageSize);
					
				} catch (SQLException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			  return list;
		}
	 
	 public int delete(String classId){
			int result=0;
			
			String sql="update newsclass set isDel=1 where classId=? ";
				//假删除，将isdel置为1，好处，数据库管理员可以恢复
			
			try {
				result=runner.update(sql, classId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
			}
	
	 
	 public int insert(NewsClass newsClass){
			int result=0;
			
			/*用来执行一个更新（插入、删除的操作）*/
			String sql="insert into newsclass(content,isDel,type) "
			+"values(?,?,?)";
			
			try {
				result =runner.update(sql,newsClass.getContent(),
						0,1);			
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}		
			return result;
		}
	 
	 
}
