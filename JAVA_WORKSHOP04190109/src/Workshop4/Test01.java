package Workshop4;

public class Test01 {

	public static void main(String[] args) {
		int[][] arr2 = {{5, 5},
				{10,10,10,10,10},
				{20,20,20},
				{30,30,30,30}};
		int total = 0;
		double avg = 0.0;
		int count = 0;
		
	 for(int x = 0; x < arr2.length ; x ++) {
			for(int y = 0; y < arr2[x].length; y ++) {
				total += arr2[x][y];
				count++;
	}
       }
	 	avg = total/count;
	 	
		System.out.println("total = " + total);
		System.out.println("average = " + avg);
	}
}