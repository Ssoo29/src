package workshop02;

import java.util.*;

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° ���� �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���� �Է� : ");
		int num2 = sc.nextInt();
		System.out.print("����° ���� �Է� : ");
		int num3 = sc.nextInt();
		
		if((num1 >= 1 && num1 <= 5) && (num2 >= 1 && num2 <= 5) && (num3 >= 1 && num3 <= 5)) {
		if(num1 > num2 && num1 > num3) {
			System.out.println("�ִ밪 : " + num1);
			if(num2 > num3) {
				System.out.print("�ּҰ� : " + num3);
			}
		}else if(num2 > num3 && num2 > num1){
			System.out.println("�ִ밪 :" + num2);
				if(num3 > num1) {
					System.out.print("�ּҰ� : " + num1);
				}
		}else if(num3 > num1 && num3 > num2) {
			System.out.println("�ִ밪 : " + num3);
			if(num1 > num2) {
				System.out.println("�ּҰ� : " + num2);
			}
		}
		}else {
			System.out.println("���ڸ� �ٽ� �Է��Ͻÿ�.");
		}
		}
	}


