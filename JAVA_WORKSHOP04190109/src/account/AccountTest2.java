package account;

public class AccountTest2 {

	public static void main(String[] args) {
		Account[] ac = new Account[5];
		
		for(int i = 0; i < ac.length; i++) {
			ac[i] = new Account("222-0101-211" + String.valueOf(i + 1) , 100000, 4.5);
		}
		
		for(Account a : ac) {
			System.out.println(a.accountInfo());
		}
		
		System.out.println();
		for(Account a : ac) {
			a.setInterestRate(3.7);
			System.out.println(a.accountInfo() + " " + (int)a.calculateInterest() + "¿ø");
		
		}
	
	}
}
