public class SignupWalletAcc implements Registeration {

	private WalletValidation validator;

	private String walletAccNum;
	private WalletProvider walletProvider;

	public SignupWalletAcc(String walletAccNum, WalletProvider walletProvider) {
		this.walletAccNum = walletAccNum;
		this.walletProvider = walletProvider;
	}

	public boolean signup(String username, String password, String phoneNum) {
		if (validator.validateBasicAcc(username, password, phoneNum)) {
			if(validator.validateWalletData(walletAccNum, walletProvider)) {
				return true;
			} 
		}
		return false;
	}
}