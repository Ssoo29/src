package workshop03;

public class Test02 {

	public static void main(String[] args) {
		Calc c = new Calc();
		int num = Integer.parseInt(args[0]);
		int sum = 0;
		
		if(num >= 5 && num <= 10) {
			sum = c.calculate(num);
			
		}else {
			System.out.println("�ٽ� �Է��ϼ���.");
		}
		System.out.println(sum);
	}

}
