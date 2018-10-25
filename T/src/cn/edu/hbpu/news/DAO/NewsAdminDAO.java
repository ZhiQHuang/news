package cn.edu.hbpu.news.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.edu.hbpu.news.Util.DBCPUtils;
import cn.edu.hbpu.news.model.NewsAdmin;





import com.mysql.jdbc.Connection;


public class NewsAdminDAO {
   
QueryRunner runner=new QueryRunner(DBCPUtils.getDataSource());
	
	
	public int changePassword(String username,String password) {
		
		int result=0;
		String sql="update newsadmin set password=? where userName=?";
	
		try {
			result=runner.update(sql, password,username);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
		
		}
    
	public List<NewsAdmin> getListByPage(int startIndex,int PageSize){
		List<NewsAdmin> list= new ArrayList<NewsAdmin>();
		String sql="select * from newsadmin where isDel=0 "
		  +"and type='2' or type='3' "+"order by  adminId asc limit ?,?";
		 BeanListHandler<NewsAdmin> bh=
	     new BeanListHandler<NewsAdmin>(NewsAdmin.class);
		  try {
				list=runner.query(sql,bh,startIndex,PageSize);
				
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		 
		
		
		return list;
		
		
	}
	public int getTotalRecordNum(){
		Long num=null;
		String sql="select count(*) from newsadmin where isDel=0 ";
		 try {
			 Object obj=runner.query(sql, new ScalarHandler());
			 num=(Long)obj;
			 return num.intValue();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
	
    public List<NewsAdmin> getmanager(){
    	List<NewsAdmin> list=new ArrayList<NewsAdmin>();
		String sql="select * from newsadmin where isDel=0 "
				+"order by adminId desc";			
    	BeanListHandler<NewsAdmin> bh=
    			new BeanListHandler<NewsAdmin>(NewsAdmin.class);
    	try {
			list=runner.query(sql,bh);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    	return list;
    }

    public String getAdminType(String username){
    	NewsAdmin newsAdmin=new NewsAdmin();
		String sql="select * from newsadmin where isDel=0 and username=?";	
    	BeanHandler<NewsAdmin> bh=
    			new BeanHandler<NewsAdmin>(NewsAdmin.class);
    	try {
    		
    		newsAdmin=runner.query(sql,bh,username);	
    		return newsAdmin.getType();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    	return "0";
    }
	
	
	public boolean isExist(String username,String password){
		boolean result=false;
		String sql="select * from newsadmin where username=? and password=?"
			+"and isDel=0";
		BeanHandler<NewsAdmin> bh=new BeanHandler<NewsAdmin>(NewsAdmin.class);
		NewsAdmin admin= null;
		
		try {
			admin=runner.query(sql,bh,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (admin!=null) 
			result=true;
		return result;
		
	}
	public int delete(String adminId){
		int result=0;
		
		String sql="update newsadmin set isDel=1 where adminId=? ";
			//假删除，将isdel置为1，好处，数据库管理员可以恢复
		
		try {
			result=runner.update(sql, adminId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		}
	
	public int insert(NewsAdmin newsAdmin){
		int result=0;
		
		/*用来执行一个更新（插入、删除的操作）*/
		String sql="insert into newsadmin(userName,password,type,isDel) "
		+"values(?,?,?,?)";
		
		try {
			result =runner.update(sql,newsAdmin.getUsername(),
					newsAdmin.getPassword(),newsAdmin.getType(),
					0);			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}		
		return result;
		
	}
	
	
	
	
}
