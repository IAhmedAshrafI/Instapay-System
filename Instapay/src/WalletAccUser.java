public class WalletAccUser extends User {

	private WalletAccTransfer transferStrategy;
	private WalletAcc walletAcc;

	public void operation() {
		// TODO - implement WalletAccUser.operation
		throw new UnsupportedOperationException();
	}

	public void setTransferStrategy(WalletAccTransfer strategy) {
		this.transferStrategy = strategy;
	}

	public void setWalletAcc(WalletAcc walletAcc) {
		this.walletAcc = walletAcc;
		walletAcc.setPhoneNum(phoneNum);
	}

	public WalletAccTransfer getTransferStrategy() {
		return transferStrategy;
	}

	public WalletAcc getWalletAcc() {
		return walletAcc;
	}

	public void setBalance(double balance) {
		walletAcc.setBalance(balance); 
		this.balance = balance;
	}

	double getBalance() {
		return walletAcc.getBalance();
	}

}