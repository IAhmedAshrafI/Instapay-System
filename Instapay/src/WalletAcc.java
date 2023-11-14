public class WalletAcc {
	private double balance;
	private WalletProvider walletProvider;
	private String phoneNum;

	public void setBalance(double balance) {
		this.balance = balance;
		walletProvider.setClientBalance(phoneNum, balance);
	}

	public double getBalance() {
		balance = walletProvider.getClientBalance(phoneNum);
		return balance;
	}

	public void setWalletProvider(WalletProvider walletProvider) {
		this.walletProvider = walletProvider;
		balance = walletProvider.getClientBalance(phoneNum);
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public WalletProvider getWalletProvider() {
		return walletProvider;
	}

}