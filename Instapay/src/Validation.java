import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validation {

	/**
	 * 
	 * @param username
	 * @param password
	 * @param phoneNum
	 */
	public boolean validateBasicAcc(String username, String password, String phoneNum) {
		return isValidUsername(username) && isValidPassword(password) && isValidPhoneNumber(phoneNum); 
	}

	
	
	
	boolean isValidUsername(String username) {
		// Username should contain only letters, digits, underscores, and be 3-20 characters long
        String regex = "^[a-zA-Z0-9_]{3,20}$";
        return username.matches(regex);
	}
	
	boolean isValidPassword(String password) {
		// Password should contain at least one uppercase letter, one lowercase letter, one digit, and be 8-20 characters long
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,20}$";
        return password.matches(regex);
	}
	
	boolean isValidPhoneNumber(String phoneNum) {
		// Egyptian phone number should start with "+20" followed by 10 digits
        String regex = "^\\+20[0-9]{10}$";
        return phoneNum.matches(regex);
	}
	
	public void operation() {
		// TODO - implement Validation.operation
		throw new UnsupportedOperationException();
	}

}