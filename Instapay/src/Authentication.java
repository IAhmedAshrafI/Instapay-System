public class Authentication {
	public boolean login(String username, String pass) {
		if(Instapay.db.checkBUser(username)){
			if(Instapay.db.getUser(username).getPassword().equals(pass)){
				Instapay.user = Instapay.db.getUser(username);
				Instapay.userAccType = AccType.BA;
				return true;
			}
			else{
				Instapay.response.put("error message","Wrong password");
				return false;
			}
		} else if(Instapay.db.checkWUser(username)){
			if(Instapay.db.getUser(username).getPassword().equals(pass)){
				Instapay.user = Instapay.db.getUser(username);
				Instapay.userAccType = AccType.WA;
				return true;
			}
			else{
				Instapay.response.put("error message","Wrong password");
				return false;
			}
		} else {
			Instapay.response.put("error message","User not found");
			return false;
		}
	}

	public void logout() {
		Instapay.user = null;
	}
}