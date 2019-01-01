package workshop1;

import java.util.*;

public class Test01 {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("첫번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자 : ");
		int num2 = sc.nextInt();
		
		if(num2 / num1 <= 1) {
			System.out.println("나머지는 1보다 작거나 같다!");
		}else {
			System.out.println("나머지는 1보다 크다!");
		}
		
	}

}
