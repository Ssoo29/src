package workshop1;

import java.util.*;

public class Test02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		double multi = 1;
		double avg = 0;
		int count = 0;
		
		System.out.print("숫자 입력 : ");
		int num1 = sc.nextInt();
		if(num1 >=  5 && num1 <= 10) {
			for(int i = 1; i <= num1; i++) {
				sum = i + sum;
				multi = i * multi;
				count ++;
			}
		}else {
			System.out.println("다시 입력하세요.");
		}
		avg = sum/count;
			System.out.println("합 : " + sum);
			System.out.println("곱 : " + multi);
			System.out.println("평균 : " + avg);
				}

}
