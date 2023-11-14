public class BankAcc {

	private double balance;
	private String accNum;
	private Bank bank;

	public void setBalance(double balance) {
		bank.setClientBalance(accNum, balance);
		this.balance = balance;
	}

	public double getBalance() {
		balance = bank.getClientBalance(accNum);
		return balance;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Bank getBank() {
		return bank;
	}

}