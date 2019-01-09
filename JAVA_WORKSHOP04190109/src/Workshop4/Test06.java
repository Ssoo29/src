package Workshop4;

import java.util.*;

public class Test06 {

	public static void main(String[] args) {
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		double sum = 0.;
		double avg = 0.;
		int count = 0;

		if (args.length == 2) {
			if (num1 >= 1 && num1 <= 5 && num2 >= 1 && num2 <= 5) {
				int[][] arr = new int[num1][num2];
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						arr[i][j] = (int)(Math.random() * 5) + 1;
						System.out.print(arr[i][j] + " ");
						sum += arr[i][j];
						count++;
					}
					System.out.println();
				}
				avg = sum / count;
				System.out.println("sum = " + sum);
				System.out.println("avg = " + avg);
				
			}else {
				System.out.println("숫자를 확인 하세요.");
			}
			System.out.println();
			
		} else {
			System.out.println("다시 입력 하세요");
		}
	}
}
