package common;

import java.io.FileReader;
import java.sql.*;
import java.util.*;

import employee.exception.EmployeeException;
//싱글톤(SingleTon) 디자인 패턴
//프로그램 구동 내내 메모리에 한 번만 기록되어서 사용됨
//static 메모리를 사용하게 함

public class JDBCTemplate {
	 
	public static Connection getConnection() throws EmployeeException{
	Connection conn = null;
	Properties prop = new Properties();
	
	
	try {
		prop.load(new FileReader("properties/driver.properties"));	
	
		Class.forName(prop.getProperty("driver"));
		conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pwd"));	
		
		
	}catch (Exception e) {
		throw new EmployeeException(e.getMessage());
	}return conn;
	}
	
	public static void close(Connection conn) throws EmployeeException{
		try {
			if(conn != null && conn.isClosed())
					conn.close();
			
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
	}
	
	public static void close(Statement stmt) throws EmployeeException{
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
			
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
	}
	
	public static void close(ResultSet rset) throws EmployeeException{
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
			
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		
	}
		
	
	
	public static void commit(Connection conn) throws EmployeeException{
		try {
			if(conn != null && conn.isClosed())
				conn.close();
			
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}

	}
	
	
	public static void rollback(Connection conn) throws EmployeeException{
		try {
			if(conn != null && conn.isClosed()) {
				conn.close();		
			}
			
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		
		

		
	}
	

	
}
