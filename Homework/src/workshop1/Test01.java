package workshop1;

import java.util.*;

public class Test01 {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("ù��° ���� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���� : ");
		int num2 = sc.nextInt();
		
		if(num2 / num1 <= 1) {
			System.out.println("�������� 1���� �۰ų� ����!");
		}else {
			System.out.println("�������� 1���� ũ��!");
		}
		
	}

}
