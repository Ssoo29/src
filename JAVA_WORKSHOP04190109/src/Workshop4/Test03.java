package Workshop4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test03 {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60,
					70, 80, 90, 100};
		
		List list = Arrays.asList(arr);
		Collections.reverse(list);
		System.out.println(list);
/*		
		for(int i = arr.length; i > -1; i--) {
			System.out.print(arr[i] + " ");
		}*/
	}
	}


