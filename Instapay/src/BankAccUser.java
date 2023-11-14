public class BankAccUser extends User {

	private BankAccTransfer transferStrategy;
	private BankAcc bankAcc;
	private User user;

	public void setTransferStrategy(BankAccTransfer transferStrategy) {
		this.transferStrategy = transferStrategy;
	}
	public BankAccTransfer getTransferStrategy() {
		return transferStrategy;
	}
	public void setBankAcc(BankAcc bankAcc) {
		this.bankAcc = bankAcc;
	}
	public BankAcc getBankAcc() {
		return bankAcc;
	}

	public void setBalance(double balance) {
		bankAcc.setBalance(balance);
		this.balance = balance;
	}
	
	public double getBalance() {
		return bankAcc.getBalance();
	}

}