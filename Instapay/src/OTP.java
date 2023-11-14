import java.util.Random;
public class OTP {

	private String code;

	public OTP() {
		
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getCode()
	{
		return code;
	}

	public String generate() {
		// Generate a 6-digit random number
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);

		setCode(String.valueOf(otp));

        return String.valueOf(otp);
	}

	public void operation() {
		// TODO - implement OTP.operation
		throw new UnsupportedOperationException();
	}

	public boolean verify(String OTP_code) {
		if (OTP_code.equals(getCode()))
		{
			return true;
		}
		
		return false;
	}

	/**
	 * 
	 * @param phoneNum
	 */
	public boolean send(String phoneNum) {
		return true;
	}

}