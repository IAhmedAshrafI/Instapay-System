public class WalletValidation extends Validation {
	public boolean validateWalletData(String phoneNum, WalletProvider walletProvider) {

		if(!walletProvider.containsClient(phoneNum)) {
			Instapay.response.put("message", "There is no " + walletProvider.toString() + " account for this number");
			return false;
		}

		return true;
	}

}