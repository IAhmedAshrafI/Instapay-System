public class TransferToWallet implements Transfer{

	private WalletProvider wallet;

	public TransferToWallet(WalletProvider wallet) {
		this.wallet = wallet;
	}

	public boolean transfer(String phoneNum, Double amount) {
		if(wallet.setClientBalance(phoneNum, wallet.getClientBalance(phoneNum) + amount)){
			return true;
		}
		else{
			Instapay.response.put("error message", "Server is down.");
			return false;
		}
	}
}

