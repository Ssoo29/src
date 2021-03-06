package common;

import java.io.FileReader;
import java.sql.*;
import java.util.*;
//싱글톤(SingleTon) 디자인 패턴
//프로그램 구동 내내 메모리에 한 번만 기록되어서 사용됨
//static 메모리를 사용하게 함

public class JDBCTemplate {
	 
	public static Connection getConnection() {
	Connection conn = null;
	Properties prop = new Properties();
	
	
	try {
		prop.load(new FileReader("properties/driver.properties"));	
	
		Class.forName(prop.getProperty("driver"));
		conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pwd"));	
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && conn.isClosed())
					conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && conn.isClosed())
				conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && conn.isClosed()) {
				conn.close();		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		
	}
	

	
}
