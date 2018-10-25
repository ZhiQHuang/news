package cn.edu.hbpu.news.Util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	private static DataSource dataSource;
	//1类加载的时候，读取dbcpconfig.properties文件
	static{
		InputStream is=DBCPUtils.class.getClassLoader()
		.getResourceAsStream("dbcpconfig.properties");
		//读取dbcpconfig.properties文件，得到一个输入流对象
		Properties props=new Properties();
		try{
			props.load(is);
			dataSource=BasicDataSourceFactory.createDataSource(props);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource() {
		return dataSource;
		// TODO Auto-generated method stub

	}
	public static Connection getConnection(){
		try{
			return dataSource.getConnection();
		}catch(SQLException e){
	throw new RuntimeException(e);
}
		
		
}

}

