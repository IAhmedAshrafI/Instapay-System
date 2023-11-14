public class BankValidation extends Validation {

	public void operation() {
		// TODO - implement BankValidation.operation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param bankNum
	 */
	public boolean validateBankData(String bankNum) {

		try {
            // Try to parse the input string to an integer
            int number = Integer.parseInt(bankNum);

            // If parsing is successful, the input contains only numbers
            return Instapay.db.bank.containsClient(bankNum);
        } catch (NumberFormatException e) {
            return false;
        }
		// return Instapay.db.bank.containsClient(bankNum);
    }

	public boolean validateBankUser(String username) {

		return Instapay.db.checkBUser(username);

	}
		
	}

