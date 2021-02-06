package com.stone.teleFee.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/dxzf?"
			+ "useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "83116060";
	
	//加载DB驱动
	static {
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException {
		if(conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
		}
			
		return conn;
	}
	
	//关闭资源
	public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
			
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
			
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
			
	}
	
}
