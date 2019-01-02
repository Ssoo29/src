package workshop03;

public class Test01 {

	public static void main(String[] args) {
		
		
		while(true) {
			int num1 = (int)(Math.random() * 6) + 1;
			int num2 = (int)(Math.random() * 6) + 1;
		//	System.out.println(num1);
		if(num1 - num2 > 0 && num1 - num2 <= 3) {
			System.out.println(num1 + "-" + num2 +" = "+ (num1 - num2));
		}
		}
	}

}
