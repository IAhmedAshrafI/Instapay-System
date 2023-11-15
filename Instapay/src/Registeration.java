public interface Registeration {

	final OTP otp = new OTP();

	boolean signup(String username, String password, String phoneNum);

}