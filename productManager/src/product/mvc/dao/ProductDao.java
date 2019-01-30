package product.mvc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import product.mvc.exception.productException;
import product.mvc.vo.Product;
import static common.JDBCTemplate.*;


public class ProductDao {
	
	private Properties prop = new Properties();

	public ProductDao() {
		try {
			prop.load(new FileReader("properties/query.properties"));
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayList<Product> selectAll(Connection conn) throws productException	
	{ ArrayList<Product> plist = new ArrayList<>();
	  PreparedStatement pstmt = null;
	  ResultSet rset = null;
	
	  String query = prop.getProperty("selectall");
	  
	try {
		pstmt = conn.prepareStatement(query);
		
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			Product p = new Product();
			p.setProductid(rset.getString("product_id"));
			p.setPname(rset.getString("p_name"));
			p.setPrice(rset.getInt("price"));
			p.setDescription(rset.getString("description"));
			
			plist.add(p);
		}
		
		if(plist.size() == 0) 
			throw new productException("전체 제품조회 실패");
		
		return plist;
			
	} catch (Exception e) {
		throw new productException(e.getMessage());
	} 
	}
	
	
	public Product selectRow(Connection conn, String productid) throws productException {
		Product p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectpid");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, productid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Product();
				p.setProductid(rset.getString("product_id"));
				p.setPname(rset.getString("p_name"));
				p.setPrice(rset.getInt("price"));
				p.setDescription(rset.getString("description"));
			
			}
			
			if(p == null) {
				throw new productException(productid + "찾지 못했습니다.");
			}
			
		} catch (Exception e) {
			throw new productException(e.getMessage());
		}
		return p;
	}
	
	public Product selectName(Connection conn, String pname) throws productException {
		Product p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("pname");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, pname);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Product();
				p.setProductid(rset.getString("product_id"));
				p.setPname(rset.getString("p_name"));
				p.setPrice(rset.getInt("price"));
				p.setDescription(rset.getString("description"));
			
			}
			
			if(p == null) {
				throw new productException(pname + "찾지 못했습니다.");
			}
			
		} catch (Exception e) {
			throw new productException(e.getMessage());
		}
		return p;
	}
	
	public int insertRow(Connection conn, Product p) throws productException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insert");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, p.getProductid());
			pstmt.setString(2, p.getPname());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
	
			result = pstmt.executeUpdate(); 
					
			if(result <= 0)
				rollback(conn);
			
		} catch (Exception e) {
			throw new productException(e.getMessage());
		}
		return result;
	}
	
	public int updateRow(Connection conn, String productid, int price) throws productException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updaterow");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, price);
			pstmt.setString(2, productid);
			
			result = pstmt.executeUpdate();			
			
			if(result <= 0) {
				rollback(conn);
			throw new productException("가격 수정 실패");}
			
		} catch (Exception e) {
			throw new productException(e.getMessage());
		}
		return result;
	}
	
	public int deleteRow(Connection conn, String productid) throws productException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("delete");
			
		try {
			Product p = new Product();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, productid);
			
			result = pstmt.executeUpdate();			
			
			if(result <= 0) {
				rollback(conn);
			throw new productException("삭제 실패");}
			
		} catch (Exception e) {
			throw new productException(e.getMessage());
		}return result;
		
	}
			
			
			
	
}
