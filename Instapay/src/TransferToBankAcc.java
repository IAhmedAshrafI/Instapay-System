public class TransferToBankAcc implements Transfer {

	private Bank bank;

	public TransferToBankAcc(Bank bank) {
		this.bank = bank;
	}

	public boolean transfer(String accNum, Double amount) {
		if(bank.setClientBalance(accNum, bank.getClientBalance(accNum) + amount)){
			return true;
		}
		else{
			Instapay.response.put("error message", "Server is down.");
			return false;
		}
	}

}