package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import product.mvc.exception.productException;

public class JDBCTemplate {

	public static Connection getConnection() throws productException{
	Connection conn = null;
	Properties prop = new Properties();
	
	try {
		
		prop.load(new FileReader("properties/driver.properties"));	
		
		Class.forName(prop.getProperty("driver"));
		conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pwd"));	
		
	} catch (Exception e) {
		throw new productException(e.getMessage());
	}
	return conn;
	}
	
	
	public static void close(Connection conn) throws productException{
		try {
			if(conn != null && conn.isClosed())
					conn.close();
			
		} catch (Exception e) {
			throw new productException(e.getMessage());
		}
		
		
	}
	
	public static void close(Statement stmt) throws productException{
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
			
		} catch (Exception e) {
			throw new productException(e.getMessage());
		}
		
		
	}
	
	public static void close(ResultSet rset) throws productException{
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
			
		} catch (Exception e) {
			throw new productException(e.getMessage());
		}
		
	}
	
	
	public static void commit(Connection conn) throws productException{
		try {
			if(conn != null && conn.isClosed())
				conn.close();
			
		} catch (Exception e) {
			throw new productException(e.getMessage());
		}

	}
	
	
	public static void rollback(Connection conn) throws productException{
		try {
			if(conn != null && conn.isClosed()) {
				conn.close();		
			}
			
		} catch (Exception e) {
			throw new productException(e.getMessage());
		}
		
	}
	

	
	
	
	
}