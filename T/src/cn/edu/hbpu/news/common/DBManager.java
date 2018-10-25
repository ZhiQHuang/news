package cn.edu.hbpu.news.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

public class DBManager {
	
	public static Connection getConn(){
		Connection conn=null;
		String url="jdbc:mysql://127.0.0.1:3309/db_news"+
		"?useUnicode=true&characterEncoding=utf-8";
		String uid="root";
		String pass="123456";
		DbUtils.loadDriver("com.mysql.jdbc.Driver");//加载驱动
		try{
			conn=DriverManager.getConnection(url, uid, pass);
			//建立连接
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn){
		try{
			DbUtils.close(conn);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
