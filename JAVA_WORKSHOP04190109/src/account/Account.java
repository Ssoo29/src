package account;

public class Account {
	private String account;
	private int balance;
	private double interestRate;
	
	public Account() {}
	public Account(String account, int balance,
					double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public double calculateInterest() {
		return this.balance * this.interestRate/100;
	}
	
	public void deposit(int money) {
		this.balance += money;
	}
	
	public void withdraw(int money) {
		this.balance -= money;
	}
	
	public String accountInfo() {
		return "계좌번호: " + account + " 잔액: " + balance + "원  이자율: " + interestRate+"%";
	}

}
