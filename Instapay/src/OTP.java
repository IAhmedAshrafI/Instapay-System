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

	public void generate() {
		// Generate a 6-digit random number
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);

		setCode(String.valueOf(otp));

        code = String.valueOf(otp);
	}

	public boolean verify(String OTP_code) {
		if (OTP_code.equals(getCode()))
		{
			return true;
		}
		
		return false;
	}


	public boolean send(String phoneNum) {
		generate();
		System.out.println(code + " is your Instapay OTP. Do not share it with anyone.");
		return true;
	}

}