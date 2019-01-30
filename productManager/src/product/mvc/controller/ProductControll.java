package product.mvc.controller;

import java.util.ArrayList;

import product.mvc.exception.productException;
import product.mvc.service.productService;
import product.mvc.vo.Product;

public class ProductControll {

	private productService pservice = new productService();
	
	public ProductControll() {}
	
	public ArrayList<Product> selectAll() {
		ArrayList<Product> plist = null;
		
		try {
			plist = pservice.selectAll();
			if(plist.size() > 0)
				System.out.println("전체 조회 실패하였습니다.");
			
			
		} catch (productException e) {
			e.getMessage(); 
		}
		
		return plist;
		
	}
	
	public Product selectRow(String productid) {
		Product p = null;
		
		try {
			p = pservice.selectRow(productid);
		} catch (productException e) {
			e.getMessage(); 
		}
		
		return p;
		
	}
	
	public Product selectName(String pname) {
		Product p = null;
		
		try {
			p = pservice.selectName(pname);
		} catch (productException e) {
			e.getMessage(); 
		}
		
		return p;
		
	}
	
	public void insertRow(Product p) {
		try {
			int result = pservice.insert(p);
			
			if(result > 0)
				System.out.println("제품 추가 성공");		
		} catch (productException e) {
			e.getMessage(); 
		}
		return;
	}
	
	
	public void updateRow(String productid, int price) {
		int result;
		try {
			result = pservice.updateRow(productid, price);
			if(result > 0) {
				System.out.println("수정 성공");
			}
			
		} catch (productException e) {
			e.getMessage(); 
		}
		return;
		
	}
	
	public void delete(String productid) {
		
		try {
			int result = pservice.delete(productid);
			if(result > 0)
				System.out.println("삭제 성공");

		} catch (productException e) {
			e.getMessage(); 
		}
		return;

	}
	
	
}
