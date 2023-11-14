public class TransferToWallet implements BankAccTransfer, WalletAccTransfer {

	private WalletProvider wallet;

	public TransferToWallet(WalletProvider wallet) {
		this.wallet = wallet;
	}

	public boolean transfer(String phoneNum, Double amount) {
		wallet.setClientBalance(phoneNum, wallet.getClientBalance(phoneNum) + amount);

		return true;
	}
}

