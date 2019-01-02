package workshop1;

import java.util.*;

public class Test01 {

	public static void main(String[] args) {
		if(Integer.parseInt(args[0])%Integer.parseInt(args[1]) < 1) {
			System.out.println("나머지가 1보다 작거나 같다.");
		}else {
			System.out.println("나머지가 1보다 크다.");
		}
		
	}

}
