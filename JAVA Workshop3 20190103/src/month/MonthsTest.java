package month;

public class MonthsTest {

	public static void main(String[] args) {
		Months m = new Months();
		int month = Integer.parseInt(args[0]);
		int re = 0;
		
		if(month >= 1 && month <= 12) {
			re = m.getDays(month);
		}else {
			System.out.println("�ٽ� �Է����ּ���.");
		}
		System.out.println("�Է¹����� : " + month+"��");
		System.out.println("���������� : " + re+"��");
	}

}
