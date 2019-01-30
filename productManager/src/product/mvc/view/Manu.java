package product.mvc.view;

import java.util.ArrayList;
import java.util.Scanner;

import product.mvc.controller.ProductControll;
import product.mvc.vo.Product;
import product.mvc.dao.*;

public class Manu {
	
	private Scanner sc = new Scanner(System.in);
	private ProductControll pcontroll = new ProductControll();

	public Manu() {}
	
	public void displayMenu() {
		do {
			System.out.println("1. 전체 조회\r\n" + 
					"   2. 추가 : 추가후 id로 조회 확인함\r\n" + 
					"   3. 수정 : id으로 조회 후 가격 수정함\r\n" + 
					"   4. 삭제 : id로 조회 후 삭제함\r\n" + 
					"   5. 검색 : 이름으로 조회함\r\n" + 
					"   6. 끝내기");
			int no = sc.nextInt();
	
			switch(no){
			case 1 : displayList(pcontroll.selectAll());
			case 2 : displayRow(pcontroll.selectRow(inputproductid()));
			case 3 : displayUpdate(pcontroll.updateRow(productid, price);
			case 4 : displayDelete(); 
			case 5 : displayRowName();
			case 6 : return;
		
			}

		}while(true);

	}
	public String inputproductid() {
		System.out.print("제품 아이디 입력 : ");
		
		return sc.next();
	
	}
	
	public void inputpidpname() {
		
	}
	
	
	public void displayList(ArrayList<Product> plist) {
		System.out.println("제품은" + plist.size() + "개");
		System.out.println(plist.toArray());
	}
	
	public void displayRow(Product p) {
		System.out.println("제품 아이디로 찾은 도서 : " + p);
		
	}
	
	public void displayRowName() {}
	
	public void displayInsert() {}
	
	public void displayUpdate() {
		
		System.out.print("가격을 바꾸고 싶은 제품 아이디 : ");
		String productid = sc.next();
		System.out.print("수정 가격 : ");
		int price = sc.nextInt();
		
		pcontroll.updateRow(productid, price);
		
		
		
	}
	
	public void displayDelete() {}
}
