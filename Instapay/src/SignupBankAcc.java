public class SignupBankAcc implements Registeration {

	private BankValidation validator;

	public void operation() {
		// TODO - implement SignupBankAcc.operation
		validator.validateBankData("1");
	}

	public boolean signup() {
		return true;
	}

}