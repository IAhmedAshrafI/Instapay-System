public class TransferToBankAcc implements BankAccTransfer {

	private Bank bank;

	public TransferToBankAcc(Bank bank) {
		this.bank = bank;
	}

	public boolean transfer(String accNum, Double amount) {
		bank.setClientBalance(accNum, bank.getClientBalance(accNum) + amount);

		return true;
	}

}