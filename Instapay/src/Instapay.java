import java.util.HashMap;
import java.util.Scanner;

public class Instapay {

	private Registeration registeration;
	public static User user;
	private Payment payment;
	private AccType UserAccType;
	private Authentication authentication;
	private Validation validation;
	public static DB db = new DB();

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

	public Instapay() {
		HashMap <String, Double> map = new HashMap<>();
		map.put("01144455531", 50000.0);
		map.put("01155544431", 60000.0);
		db.fawry.setClients(map);
		HashMap <String, Double> vodaMap = new HashMap<>();
		vodaMap.put("01044455531", 50000.0);
		vodaMap.put("01055544431", 20000.0);
		db.vodafoneCash.setClients(vodaMap);
		HashMap <String, Double> cibMap = new HashMap<>();
		cibMap.put("01244455531", 50000.0);
		cibMap.put("01255544431", 100000.0);
		db.cib.setClients(cibMap);
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("|----------------------------------------------------------------------|");
		System.out.println("|                                                                      |");
		System.out.println("|----------------------Welcome to Instapay System----------------------|");
		System.out.println("|                                                                      |");
		System.out.println("|----------------------------------------------------------------------|");

		System.out.println("SignUp / Login");
		while (true) {
			System.out.println("1. SignUp with Bank Account");
			System.out.println("2. SignUp with Wallet Account");
			System.out.println("3. Login");
			int userChoice = scanner.nextInt();	
			switch (userChoice) {
				case 1:
					registerBankAccView(scanner);
					break;
				case 2:
					registerWalletAccView(scanner);
					break;

				case 3:
					AuthenticationView(scanner);
					break;
				
				default:
                    System.out.println("Invalid choice. Please enter a valid option.");

			}

			if(user != null) {
				
				userView(scanner);
				break;
			}

		}
		
	}

	private void registerBankAccView(Scanner scanner) {
		String name, password, BankNum, phoneNumber, phoneNumber_OTP, OTP_Code;
		Validation validation = new Validation();
		BankValidation bankValidation = new BankValidation();
		System.out.print("Username: ");
		name = scanner.next();

		while(bankValidation.validateBankUser(name))
		{
			System.out.println("This username is already exist.");
			System.out.print("Username: ");
			name = scanner.next();
		}

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

		System.out.println("Bank number: ");
		BankNum = scanner.next();

		while(!bankValidation.validateBankData(BankNum))
		{
			System.out.println("There is no bank number related with your account.");
			System.out.println("Bank number: ");
			BankNum = scanner.next();
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
						BankAccUser bankUser = new BankAccUser();

						bankUser.setUsername(name);
						bankUser.setPassword(password);
						bankUser.setPhoneNum(phoneNumber_OTP);
						BankAcc bankAcc = new BankAcc();
						bankAcc.setBank(db.bank);
						bankUser.setBankAcc(bankAcc);

						db.addBankUserToDB(bankUser);

						System.out.println("Account created successfully.");
					}

				}

			}
		}
	}

	private void registerWalletAccView(Scanner scanner) {
		String name, password, phoneNumber, phoneNumber_OTP, OTP_Code;
		Validation validation = new Validation();
		WalletValidation walletValidation = new WalletValidation();
		System.out.print("Username: ");
		name = scanner.next();

		while(walletValidation.validateWalletUser(name))
		{
			System.out.println("This username is already exist.");
				System.out.print("Username: ");
				name = scanner.next();
		}

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

			System.out.println("Choose your Wallet");
			System.out.println("1. CIB");
			System.out.println("2. Vodafone Cash");
			System.out.println("3. Fawry");
			System.out.println("4. Back");
		int ChooseWallet = scanner.nextInt();

		switch (ChooseWallet) {
			case 1:
			CIB cib = new CIB();
			if (walletValidation.validateWalletData(phoneNumber, cib)) {

				System.out.println("This phone number is existed in cib.");

			}else{
				System.out.println("This phone number is NOT existed in cib.");
			}
				
				break;

				case 2:
				VodafoneCash vc = new VodafoneCash();
				if (walletValidation.validateWalletData(phoneNumber,vc)){
					System.out.println("This phone number is existed in vodafone cash.");
					} else {
						System.out.println("This phone number is NOT existed in vodafone cash.");
						}
						break;

				case 3:
				Fawry fw = new Fawry();
				if (walletValidation.validateWalletData(phoneNumber, fw)){
					System.out.println("This phone number is existed in fawry.");
				}else
				{
					System.out.println("This phone number is NOT existed in fawry.");
				}

				case 4:

				System.out.println("holaa");
				break;
		
			default:
				break;
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

							WalletAccUser WalletUser = new WalletAccUser();

							WalletUser.setUsername(name);
							WalletUser.setPassword(password);
							WalletUser.setPhoneNum(phoneNumber);

							db.addWalletUserToDB(WalletUser);

							System.out.println("Account created successfully.");
						}

					}

				}
			}
	}

	private void AuthenticationView(Scanner scanner) {
		String name, password;
		Authentication auth = new Authentication();
		System.out.print("Username: ");
		name = scanner.next();

		System.out.print("Password: ");
		password = scanner.next();

		if (auth.login(name, password))
		{
			System.out.println("Login successfully");

			return;
		}
	}

	public void userView(Scanner scanner) {
		while (true) {
			System.out.println("Hello, " + user.getUsername() + '\n');
			System.out.println("1. Transfer to Wallet");
			System.out.println("2. Transfer to Another instapay account");
			System.out.println("3. Inquire about your balance");
			System.out.println("4. Pay bills");

			if(getUserType() == AccType.BA) {
				System.out.println("5. Transfer to Bank Account");
			}

			int userChoice = scanner.nextInt();	
			switch (userChoice) {
				case 1:
					transferToWalletView(scanner);
					break;
				case 2:
					transferToInstaAccView(scanner);
					break;

				case 3:
					inquireBalanceView(scanner);
					break;

				case 4:
					payBillsView(scanner);
					break;

				case 5:
					if(getUserType() == AccType.BA) {
						transferToBankView(scanner);
						break;
					}
				default:
                    System.out.println("Invalid choice. Please enter a valid option.");

			}
			
		}
	}

	void transferToWalletView(Scanner scanner) {
		while (true) {
            System.out.println("Enter a number (1 for fawry 2 for vodafone 3 for cib):");
            int userChoice = scanner.nextInt();

            System.out.println("Enter a phone number:");
            String phoneNumber = scanner.next();

			System.out.println("Enter The amount");
            double amount = scanner.nextDouble();

            switch (userChoice) {
				case 1:
					if(db.fawry.containsClient(phoneNumber)) {
						user.setTransferStrategy(new TransferToWallet(db.fawry));
						if(user.transfer(phoneNumber, amount)) {
							System.out.println("Transfered Successfully");
						} else {
							System.out.println("Not sufficient");
						}
					} else {
						System.out.println("This Phone Number doesn't have a fawry Wallet");
					}
					break;
				
				case 2:
					if(db.vodafoneCash.containsClient(phoneNumber)) {
						user.setTransferStrategy(new TransferToWallet(db.vodafoneCash));
						if(user.transfer(phoneNumber, amount)) {
							System.out.println("Transfered Successfully");
						} else {
							System.out.println("Not sufficient");
						}
					} else {
						System.out.println("This Phone Number doesn't have a Vodafone Cash Wallet");
					}
					break;
				
				case 3:
					if(db.cib.containsClient(phoneNumber)) {
						user.setTransferStrategy(new TransferToWallet(db.cib));
						if(user.transfer(phoneNumber, amount)) {
							System.out.println("Transfered Successfully");
						} else {
							System.out.println("Not sufficient");
						}
					} else {
						System.out.println("This Phone Number doesn't have a CIB Wallet");
					}
					break;
				
				// Break out of the loop if the number doesn't match 1, 2, or 3
				default:
					System.out.println("Number does not match 1, 2, or 3. Breaking out of the loop.");
				}
			}
            
	}

	void transferToInstaAccView(Scanner scanner) {
		System.out.println("Enter a username:");
		String username = scanner.next();

		System.out.println("Enter The amount");
		double amount = scanner.nextDouble();
		user.setTransferStrategy(new TransferToAcc());

		if(db.checkBUser(username)) {
			user.transfer(username, amount);
		} else if(db.checkWUser(username)) {
			user.transfer(username, amount);
		} else {
			System.out.println("There is no such username");
		}
	}

	void transferToBankView(Scanner scanner) {
		System.out.println("Enter a Bank number:");
		String bankAccNum = scanner.next();

		System.out.println("Enter The amount");
		double amount = scanner.nextDouble();
		user.setTransferStrategy(new TransferToBankAcc(db.bank));
		
		if(db.bank.containsClient(bankAccNum)) {
			user.transfer(bankAccNum, amount);
		} else {
			System.out.println("There is no such bank account number");
		}
	}

	void inquireBalanceView(Scanner scanner) {

	}

	void payBillsView(Scanner scanner) {

	}

	public static void main(String[] args) {
		Instapay instapay = new Instapay();
        instapay.run();
	}


}