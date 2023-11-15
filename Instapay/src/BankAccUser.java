public class BankAccUser extends User {
	private BankAcc bankAcc;

	public void setTransferStrategy(Transfer transferStrategy) {
		this.transferStrategy = transferStrategy;
	}
	public Transfer getTransferStrategy() {
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

	public boolean transfer(String transferTo, Double amount) {
		if (amount < getBalance()) {
			return false;
		}
		withdraw(amount);
		return transferStrategy.transfer(transferTo, amount);
	}

}