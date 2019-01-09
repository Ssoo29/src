package Workshop4;

public class Calc {

		public int calculate(int data) {
			int sum = 0;
			
			for(int i = 0; i <= data; i++) {
				int jjak = i % 2;
				if(jjak == 0) {
					sum += i;
				}
			}
			
			return sum;
		}
}
