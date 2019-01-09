package Workshop4;

public class Test05 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		int sum = 0;
		
		
		if(num <= 5) {
			for(int i = num; i <= 10; i++) {
			if(i % 3 != 0 && i % 5 != 0) {
				sum += i;
				System.out.print(i + " + ");
			}
			}
		}
		System.out.println();
		System.out.println("°á°ú: " + sum);
	}

}
