package Workshop4;

public class Test02 {

	public static void main(String[] args) {
		int[] arr3 = new int[5];
		int sum = 0;
		int count = 0;
		double avg = 0.;
		
		for(int i = 0; i < arr3.length; i++) {
			arr3[i] = (int)(Math.random() * 10) + 1;
			sum += arr3[i];
			count++;
		}
		
		avg = sum/count;
		
		for(int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		
		System.out.println();
		System.out.println("sum = " + sum);
		System.out.println("avg = " + avg);
	}

}
