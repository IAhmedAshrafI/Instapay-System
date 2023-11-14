public class WalletValidation extends Validation {

	public void operation() {
		// TODO - implement WalletValidation.operation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param phoneNum
	 * @param WalletName
	 */
	public boolean validateWalletData(String phoneNum, WalletProvider WalletName) {

		return Instapay.db.walletProvider.containsClient(phoneNum);
	}

	public boolean validateWalletUser(String username) {

		return Instapay.db.checkWUser(username);

	}

}