public class WalletAccUser extends User {

	private WalletAcc walletAcc;


	public void setWalletAcc(WalletAcc walletAcc) {
		this.walletAcc = walletAcc;
		walletAcc.setPhoneNum(phoneNum);
	}
	public void setTransferStrategy(Transfer strategy) {
		this.transferStrategy = strategy;
	}

	public Transfer getTransferStrategy() {
		return transferStrategy;
	}

	public WalletAcc getWalletAcc() {
		return walletAcc;
	}

	public void setBalance(double balance) {
		walletAcc.setBalance(balance); 
		this.balance = balance;
	}

	public double getBalance() {
		return walletAcc.getBalance();
	}

}