import java.util.Scanner;

public class Instapay {

	private Registeration registeration;
	private User user;
	private Payment payment;
	private AccType UserAccType;
	private Authentication authentication;
	private Validation validation;
	public DB db;

	public void operation() {
		// TODO - implement System.operation
		throw new UnsupportedOperationException();
	}

	public AccType getUserType() {
        return UserAccType;
    }

    // Setter method (optional)
    public void setUserType(AccType UserAccType) {
        this.UserAccType = UserAccType;
    }

	public void run() {

		String name, password, phoneNumber, phoneNumber_OTP, OTP_Code;
		boolean continueDisplay = true;
		Scanner scanner = new Scanner(System.in);

		System.out.println("|----------------------------------------------------------------------|");
		System.out.println("|                                                                      |");
		System.out.println("|----------------------Welcome to Instapay System----------------------|");
		System.out.println("|                                                                      |");
		System.out.println("|----------------------------------------------------------------------|");

		System.out.println("SignUp / Login");
		while (continueDisplay) {

			System.out.println("1. SignUp with Bank Account");
			System.out.println("2. SignUp with Wallet Account");
			System.out.println("3. Login");
			int userChoice = scanner.nextInt();
			Validation validation = new Validation();
			
			switch (userChoice) {
				case 1:
					System.out.print("Username: ");
					name = scanner.next();

					while (!validation.isValidUsername(name)) {
						System.out.println("Invalid Username.");
						System.out.print("Username: ");
						name = scanner.next();
					}

					System.out.print("Password: ");
					password = scanner.next();

					while (!validation.isValidPassword(password)) {
						System.out.println("Invalid password.");
						System.out.print("Password: ");
						password = scanner.next();
					}

					System.out.print("Phone number: ");
					phoneNumber = scanner.next();

					while (!validation.isValidPhoneNumber(phoneNumber)) {

						System.out.println("Invalid Phone number.");
						System.out.print("Phone number: ");
						phoneNumber_OTP = scanner.next();
					}

					Registeration SignupBankAcc = new SignupBankAcc();

					if (SignupBankAcc.signup()) {

						if (validation.validateBasicAcc(name, password, phoneNumber)) {
							System.out.println("Verify your account with phone number");
							System.out.print("Phone number: ");
							phoneNumber_OTP = scanner.next();
							while (!validation.isValidPhoneNumber(phoneNumber_OTP)) {

								System.out.println("Invalid Phone number.");
								System.out.print("Phone number: ");
								phoneNumber_OTP = scanner.next();
							}

							if (Registeration.otp.send(phoneNumber_OTP)) {
								System.out.println("Sending OTP...");
								System.out.println(Registeration.otp.generate()
										+ " is your Instapay OTP. Do not share it with anyone.");

								System.out.print("Enter OTP: ");
								OTP_Code = scanner.next();

								while (!Registeration.otp.verify(OTP_Code)) {
									System.out.println("Invalid OTP.");
									System.out.print("Enter OTP: ");
									OTP_Code = scanner.next();
								}

								if (Registeration.otp.verify(OTP_Code)) {

									DB db = new DB();

									// System.out.println("name: " + name);
									User bankUser = new BankAccUser(name, password, phoneNumber, "BA", 0.0, null, null,
											null);
									// System.out.println(bankUser.getPassword());

									db.addUserToDB(bankUser);

									System.out.println("Account created successfully.");
								}

							}

						}
					}
					break;

				case 2:

					System.out.print("Username: ");
					name = scanner.next();

					while (!validation.isValidUsername(name)) {
						System.out.println("Invalid Username.");
						System.out.print("Username: ");
						name = scanner.next();
					}

					System.out.print("Password: ");
					password = scanner.next();

					while (!validation.isValidPassword(password)) {
						System.out.println("Invalid password.");
						System.out.print("Password: ");
						password = scanner.next();
					}

					System.out.print("Phone number: ");
					phoneNumber = scanner.next();

					while (!validation.isValidPhoneNumber(phoneNumber)) {

						System.out.println("Invalid Phone number.");
						System.out.print("Phone number: ");
						phoneNumber_OTP = scanner.next();
					}

					Registeration SignupWalletAcc = new SignupWalletAcc();

					if (SignupWalletAcc.signup()) {

						if (validation.validateBasicAcc(name, password, phoneNumber)) {
							System.out.println("Verify your account with phone number");
							System.out.print("Phone number: ");
							phoneNumber_OTP = scanner.next();
							while (!validation.isValidPhoneNumber(phoneNumber_OTP)) {

								System.out.println("Invalid Phone number.");
								System.out.print("Phone number: ");
								phoneNumber_OTP = scanner.next();
							}

							if (Registeration.otp.send(phoneNumber_OTP)) {
								System.out.println("Sending OTP...");
								System.out.println(Registeration.otp.generate()
										+ " is your Instapay OTP. Do not share it with anyone.");

								System.out.print("Enter OTP: ");
								OTP_Code = scanner.next();

								while (!Registeration.otp.verify(OTP_Code)) {
									System.out.println("Invalid OTP.");
									System.out.print("Enter OTP: ");
									OTP_Code = scanner.next();
								}

								if (Registeration.otp.verify(OTP_Code)) {

									DB db = new DB();

									// System.out.println("name: " + name);
									User WalletUser = new WalletAccUser(name, password, phoneNumber, "WA", 0.0, null, null,
											null);
									// System.out.println(bankUser.getPassword());

									db.addUserToDB(WalletUser);

									System.out.println("Account created successfully.");
								}

							}

						}
					}
					break;

				case 3:
				Authentication auth = new Authentication();
					System.out.print("Username: ");
					name = scanner.next();

					System.out.print("Password: ");
					password = scanner.next();

					if (auth.login(name, password))
					{
						System.out.println("Login successfully");

						continueDisplay = false;
					}

					break;
				
					default:
                    System.out.println("Invalid choice. Please enter a valid option.");


			}

		}
	}

}