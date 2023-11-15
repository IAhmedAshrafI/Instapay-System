public class TransferToAcc implements Transfer {

	public boolean transfer(String username, Double amount) {
		User user = Instapay.db.getUser(username);
		user.deposit(amount);

		return true;
		
	}

}