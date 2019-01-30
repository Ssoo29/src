package product.mvc.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;

import product.mvc.dao.ProductDao;
import product.mvc.exception.productException;
import product.mvc.vo.Product;
import static common.JDBCTemplate.*;

public class productService {

	private ProductDao pdao = new ProductDao();
	
	public productService() {}
	
	public ArrayList<Product> selectAll() throws productException{
		
		Connection conn = getConnection();
		ArrayList<Product> plist = pdao.selectAll(conn);
		close(conn);
		
		return plist;
	}
	
	public Product selectRow(String productid) throws productException {
		Connection conn = getConnection();
		Product p = pdao.selectRow(conn, productid);
		close(conn);
		
		return p;
		
	}
	
	public Product selectName(String pname) throws productException {
		Connection conn = getConnection();
		Product p = pdao.selectName(conn, pname);
		close(conn);
		
		return p;
	}
	public int updateRow(String productid, int price) throws productException {
		Connection conn = getConnection();
		int p = pdao.updateRow(conn, productid, price);
		close(conn);
		
		return p;
	}

	public int insert(Product p) throws productException {
		Connection conn = getConnection();
		int result = pdao.insertRow(conn, p);
		
		return result;
	}
	
	public int delete(String productid) throws productException {
		Connection conn = getConnection();
		int result = pdao.deleteRow(conn, productid);
		
		return result;
	
	}
	
}
	

