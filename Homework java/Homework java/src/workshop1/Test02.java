package workshop1;

import java.util.*;

public class Test02 {

	public static void main(String[] args) {
		
		int num = Integer.parseInt(args[0]);

		double sum = 0;
		double multi = 1;

		System.out.print("숫자 입력 : ");
		if(num >=  5 && num <= 10) {
			for(int i = 1; i <= num; i++) {
				sum = i + sum;
				multi = i * multi;

			}
		}else {
			System.out.println("다시 입력하세요.");
		}
			System.out.println("합 : " + sum);
			System.out.println("곱 : " + multi);
			System.out.println("평균 : " + sum/num);
				}

}
