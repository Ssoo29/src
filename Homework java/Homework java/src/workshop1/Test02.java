package workshop1;

import java.util.*;

public class Test02 {

	public static void main(String[] args) {
		
		int num = Integer.parseInt(args[0]);

		double sum = 0;
		double multi = 1;

		System.out.print("���� �Է� : ");
		if(num >=  5 && num <= 10) {
			for(int i = 1; i <= num; i++) {
				sum = i + sum;
				multi = i * multi;

			}
		}else {
			System.out.println("�ٽ� �Է��ϼ���.");
		}
			System.out.println("�� : " + sum);
			System.out.println("�� : " + multi);
			System.out.println("��� : " + sum/num);
				}

}
