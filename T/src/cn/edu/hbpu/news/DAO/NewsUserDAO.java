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
import cn.edu.hbpu.news.model.NewsUser;
import cn.edu.hbpu.news.model.Note;

public class NewsUserDAO {
	QueryRunner runner=new QueryRunner(DBCPUtils.getDataSource());
	public boolean isExist(String username,String password){
		boolean result=false;
		String sql="select * from newsuser where username=? "+
		"and password=? and isDel=0";
		BeanHandler<NewsUser> bh
		=new BeanHandler<NewsUser>(NewsUser.class);
		NewsUser user=null;
		try {
			user=runner.query(sql, bh,username,password);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(user!=null)
			result=true;
		return result;
	}
	
	
	//判断用户名是否存在数据表中
	public boolean existName(String username){
		boolean result=false;
		String sql="select * from newsuser where username=? "+
		"and isDel=0";
		BeanHandler<NewsUser> bh
		=new BeanHandler<NewsUser>(NewsUser.class);
		NewsUser user=null;
		try {
			user=runner.query(sql, bh,username);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(user!=null)
			result=true;
		return result;
	}
	
	
	//将用户的注册信息插入到数据表中
	public int insert(NewsUser user) {
		int result=0;
		String sql="insert into newsuser(username,password,sex,question,answer,emailAddr,qq,regTime,isDel) "+
		"values(?,?,?,?,?,?,?,now(),0)";
		
		try {
			result=runner.update(sql,user.getUsername(),
					user.getPassword(),user.getSex(),
					user.getQuestion(),user.getAnswer(),
					user.getEmailAddr(),user.getQq());
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	
	public List<NewsUser> getListByPage(int startIndex,int PageSize){
		List<NewsUser> list= new ArrayList<NewsUser>();
		String sql="select * from newsuser where isDel=0 "+
				   "order by userId asc limit ?,?";
		 BeanListHandler<NewsUser> bh=
	     new BeanListHandler<NewsUser>(NewsUser.class);
		  try {
				list=runner.query(sql,bh,startIndex,PageSize);
				
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
		return list;
	}
	
	
	public int getTotalRecordNum(){
		Long num=null;
		String sql="select count(*) from newsuser where isDel=0";
		 try {
			 Object obj=runner.query(sql, new ScalarHandler());
			 num=(Long)obj;
			 return num.intValue();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int delete(String userId){
		int result=0;
		
		String sql="update newsuser set isDel=1 where userId=? ";
			//假删除，将isdel置为1，好处，数据库管理员可以恢复
		
		try {
			result=runner.update(sql, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		}




}
