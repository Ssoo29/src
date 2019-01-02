package month;

public class MonthsTest {

	public static void main(String[] args) {
		Months m = new Months();
		int month = Integer.parseInt(args[0]);
		int re = 0;
		
		if(month >= 1 && month <= 12) {
			re = m.getDays(month);
		}else {
			System.out.println("다시 입력해주세요.");
		}
		System.out.println("입력받은월 : " + month+"월");
		System.out.println("마지막일자 : " + re+"일");
	}

}
