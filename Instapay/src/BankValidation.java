public class BankValidation extends Validation {

	public boolean validateBankData(String bankNum, Bank bank) {
		if(!bank.containsClient(bankNum)) {
			System.out.println("Worked");
			Instapay.response.put("error message", "There is no bank account for this number");
			return false;
		}

		return true;
    }

		
}

