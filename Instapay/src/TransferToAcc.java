public class TransferToAcc implements Transfer {

	public boolean transfer(String username, Double amount) {
		User user = Instapay.db.getUser(username);
		if(user.deposit(amount)){
			return true;
		}
		else {
			Instapay.response.put("error message", "Server is down.");
			return false;
		}
	}

}