package Workshop4;

public class Test04 {

	public static void main(String[] args) {
		Calc cl = new Calc();
		int sum = 0;
		int num = Integer.parseInt(args[0]);
		
		if(num >= 5 && num <= 10) {
			sum = cl.calculate(num);
		}else {
			System.out.println("다시 입력");
		}
		
		System.out.print("짝수 : ");
		for(int i = 1; i <= num; i++) {
			if(i % 2 == 0) {
				 System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println("결과: " + sum);
		
	}
}
