public class Validation {
	public boolean validateBasicAcc(String username, String password, String phoneNum) {

		if(!isValidUsername(username)) {
			Instapay.response.put("error message", "Username must be unique.");
			return false;
		}

		if(!isValidPassword(password)) {
			Instapay.response.put("error message", "Password must be complex.");
			return false;
		}
		
		if(!isValidPhoneNumber(phoneNum)) {
			Instapay.response.put("error message", "Invalid Phone number.");
			return false;
		}

		return true;

	}

	boolean isValidUsername(String username) {
		return !(Instapay.db.checkBUser(username) || Instapay.db.checkWUser(username));
	}
	
	boolean isValidPassword(String password) {
		// Password should contain at least one uppercase letter, one lowercase letter, one digit, and be 8-20 characters long
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,20}$";
        return password.matches(regex);
	}
	
	boolean isValidPhoneNumber(String phoneNum) {
		// Egyptian phone number should start with "+20" followed by 10 digits
        String regex = "^0[0-9]{10}$";
        return phoneNum.matches(regex);
	}
	
}