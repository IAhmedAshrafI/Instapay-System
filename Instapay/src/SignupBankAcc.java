public class SignupBankAcc implements Registeration {

	private BankValidation validator;
	private String bankAccNum;
	private Bank bank;

	public SignupBankAcc(String bankAccNum, Bank bank) {
		this.bankAccNum = bankAccNum;
		this.bank = bank;
	}

	public boolean signup(String username, String password, String phoneNum) {
		if (validator.validateBasicAcc(username, password, phoneNum)) {
			if(validator.validateBankData(bankAccNum, bank)) {
				return true;
			}
		} 

		return false;

	}
}