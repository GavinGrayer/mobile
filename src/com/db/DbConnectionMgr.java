package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 管理数据库连接的JavaBean
 * @author Administrator
 *
 */
public class DbConnectionMgr {
	
	//把数据库连接信息定义为静态常量
	private static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	
	private static final String USERNAME = "scott";
	
	private static final String PWD = "orcl";
	
	
	static{

		
		//DRIVER_CLASS = reader.getProperties("DRIVER_CLASS");
	}

	/**
	 * 获得数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		
		Connection conn = null;
		try {
			Class.forName(DRIVER_CLASS);
			
			conn = DriverManager.getConnection(URL,USERNAME,PWD);
		
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;

	}
	
	/**
	 * 关闭数据库连接
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void close(Connection conn,Statement st,ResultSet rs){
		try{
			if(conn != null){
				conn.close();
			}
			
			if(st != null){
				st.close();
			}
			
			if(rs != null){
				
				rs.close();
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
