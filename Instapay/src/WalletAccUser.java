public class WalletAccUser extends User {

	private WalletAccTransfer transferStrategy;
	private WalletAcc walletAcc;

	public WalletAccUser(String username, String password, String phoneNum, String type, double balance, Bill[] bills,
			WalletAccTransfer transferStrategy, WalletAcc walletAcc) {
		super(username, password, phoneNum, type, balance, bills);
		this.transferStrategy = transferStrategy;
		this.walletAcc = walletAcc;
	}

	public void operation() {
		// TODO - implement WalletAccUser.operation
		throw new UnsupportedOperationException();
	}

}