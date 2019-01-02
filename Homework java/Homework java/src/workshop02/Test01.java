package workshop02;

import java.util.*;

public class Test01 {

	public static void main(String[] args) {
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int num3 = Integer.parseInt(args[2]);
		
		if((num1 >= 1 && num1 <= 5) && (num2 >= 1 && num2 <= 5) && (num3 >= 1 && num3 <= 5)) {
		if(num1 > num2 && num1 > num3) {
			System.out.println("최대값 : " + num1);
			if(num2 > num3) {
				System.out.print("최소값 : " + num3);
			}
		}else if(num2 > num3 && num2 > num1){
			System.out.println("최대값 : " + num2);
				if(num3 > num1) {
					System.out.print("최소값 : " + num1);
				}
		}else if(num3 > num1 && num3 > num2) {
			System.out.println("최대값 : " + num3);
			if(num1 > num2) {
				System.out.println("최소값 : " + num2);
			}
		}
		}else {
			System.out.println("숫자를 다시 입력하시오.");
		}
		}
	}