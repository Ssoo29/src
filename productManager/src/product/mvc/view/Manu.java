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
			System.out.println("1. ��ü ��ȸ\r\n" + 
					"   2. �߰� : �߰��� id�� ��ȸ Ȯ����\r\n" + 
					"   3. ���� : id���� ��ȸ �� ���� ������\r\n" + 
					"   4. ���� : id�� ��ȸ �� ������\r\n" + 
					"   5. �˻� : �̸����� ��ȸ��\r\n" + 
					"   6. ������");
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
		System.out.print("��ǰ ���̵� �Է� : ");
		
		return sc.next();
	
	}
	
	public void inputpidpname() {
		
	}
	
	
	public void displayList(ArrayList<Product> plist) {
		System.out.println("��ǰ��" + plist.size() + "��");
		System.out.println(plist.toArray());
	}
	
	public void displayRow(Product p) {
		System.out.println("��ǰ ���̵�� ã�� ���� : " + p);
		
	}
	
	public void displayRowName() {}
	
	public void displayInsert() {}
	
	public void displayUpdate() {
		
		System.out.print("������ �ٲٰ� ���� ��ǰ ���̵� : ");
		String productid = sc.next();
		System.out.print("���� ���� : ");
		int price = sc.nextInt();
		
		pcontroll.updateRow(productid, price);
		
		
		
	}
	
	public void displayDelete() {}
}
