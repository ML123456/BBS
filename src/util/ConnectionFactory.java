package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	
	Connection conn=null;
	
	private static final ConnectionFactory factory=new ConnectionFactory();
	
	static {
		//用来保存属性文件中的键值对
		Properties prop=new Properties();
		try {
			//获取属性文件中的内容（将属性文件中的内容读取到一个输入流中）
			InputStream in=ConnectionFactory.class.getClassLoader()
						.getResourceAsStream("dbconfig.properties");
			
			//从输入流中读取属性列表
			prop.load(in);
		} catch (Exception e) {
			System.out.println("=======配置文件读取错误=======");
		}
		
		//将所读取到的值赋值给成员变量
		driver=prop.getProperty("driver");
		dburl=prop.getProperty("dburl");
		user=prop.getProperty("user");
		password=prop.getProperty("password");
	}
	
	private ConnectionFactory() {
		
	}
	
	public static ConnectionFactory getInstance() {
		return factory;
	}
	
	public Connection makeConnection() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(dburl,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
