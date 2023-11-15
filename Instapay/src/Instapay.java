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

	public static HashMap<String , String> response = new HashMap<String , String>();


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
		String username, password, phoneNum, bankNum;
		System.out.print("Username: ");
		username = scanner.next();

		System.out.print("Password: ");
		password = scanner.next();
		
		System.out.print("Phone number: ");
		phoneNum = scanner.next();

		System.out.println("Bank number: ");
		bankNum = scanner.next();



		SignupBankAcc signupBankAcc = new SignupBankAcc(bankNum, db.bank);

		if (signupBankAcc.signup(username,password,phoneNum)) {
			if (Registeration.otp.send(phoneNum)) {
				System.out.print("Enter OTP: ");
				String OTP_Code = scanner.next();

				while (!Registeration.otp.verify(OTP_Code)) {
					System.out.println("Invalid OTP.");
					System.out.print("Enter OTP: ");
					OTP_Code = scanner.next();
				}

				if (Registeration.otp.verify(OTP_Code)) {
					BankAccUser bankUser = new BankAccUser();

					bankUser.setUsername(username);
					bankUser.setPassword(password);
					bankUser.setPhoneNum(phoneNum);
					BankAcc bankAcc = new BankAcc();
					bankAcc.setBank(db.bank);
					bankUser.setBankAcc(bankAcc);

					db.addBankUserToDB(bankUser);

					System.out.println("Account created successfully.");
				}
			}
		} else {
			System.out.println(response.get("error message"));
		}
		
	}

	private void registerWalletAccView(Scanner scanner) {

		String username, password, phoneNum;
		WalletProvider walletProvider = null;
		System.out.print("Username: ");
		username = scanner.next();

		System.out.print("Password: ");
		password = scanner.next();
		
		System.out.print("Phone number: ");
		phoneNum = scanner.next();

		System.out.println("Choose your Wallet");
		System.out.println("1. CIB");
		System.out.println("2. Vodafone Cash");
		System.out.println("3. Fawry");
		int chooseWallet;

		do {
            System.out.println("Choose a wallet provider:");
            System.out.println("1. CIB");
            System.out.println("2. Vodafone Cash");
            System.out.println("3. Fawry");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input.");
                scanner.next();
            }
            
            chooseWallet = scanner.nextInt();
        } while (chooseWallet < 1 || chooseWallet > 3);

		switch (chooseWallet) {
			case 1:
			walletProvider = db.cib;
			case 2:
			walletProvider = db.vodafoneCash;
			case 3:
			walletProvider = db.fawry;
			default:
				break;
		}

		SignupWalletAcc signupWalletAcc = new SignupWalletAcc(phoneNum, walletProvider);

		if (signupWalletAcc.signup(username,password,phoneNum)) {
			if (Registeration.otp.send(phoneNum)) {
				System.out.print("Enter OTP: ");
				String OTP_Code = scanner.next();

				while (!Registeration.otp.verify(OTP_Code)) {
					System.out.println("Invalid OTP.");
					System.out.print("Enter OTP: ");
					OTP_Code = scanner.next();
				}

				if (Registeration.otp.verify(OTP_Code)) {
					WalletAccUser walletUser = new WalletAccUser();

					walletUser.setUsername(username);
					walletUser.setPassword(password);
					walletUser.setPhoneNum(phoneNum);
					WalletAcc walletAcc = new WalletAcc();
					walletAcc.setWalletProvider(walletProvider);

					db.addWalletUserToDB(walletUser);

					System.out.println("Account created successfully.");
				}
			}
		} else {
			System.out.println(response.get("error message"));
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
							System.out.println(response.get("error message"));
						}
					} else {
						System.out.println(response.get("error message"));
					}
					break;
				
				case 2:
					if(db.vodafoneCash.containsClient(phoneNumber)) {
						user.setTransferStrategy(new TransferToWallet(db.vodafoneCash));
						if(user.transfer(phoneNumber, amount)) {
							System.out.println("Transfered Successfully");
						} else {
							System.out.println(response.get("error message"));
						}
					} else {
						System.out.println(response.get("error message"));
					}
					break;
				
				case 3:
					if(db.cib.containsClient(phoneNumber)) {
						user.setTransferStrategy(new TransferToWallet(db.cib));
						if(user.transfer(phoneNumber, amount)) {
							System.out.println("Transfered Successfully");
						} else {
							System.out.println(response.get("error message"));
						}
					} else {
						System.out.println(response.get("error message"));
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

		if(db.checkBUser(username) || db.checkWUser(username)) {
				if(user.transfer(username, amount)){
					System.out.println("Transfered Successfully");
				}
				else {
					System.out.println(response.get("error message"));
				}
		} else {
			System.out.println(response.get("error message"));
		}
	}

	void transferToBankView(Scanner scanner) {
		System.out.println("Enter a Bank number:");
		String bankAccNum = scanner.next();

		System.out.println("Enter The amount");
		double amount = scanner.nextDouble();
		user.setTransferStrategy(new TransferToBankAcc(db.bank));
		
		if(db.bank.containsClient(bankAccNum)) {
			if (user.transfer(bankAccNum, amount)){
				System.out.println("Transfered Successfully");
			} else {
				System.out.println(response.get("error message"));
			}
		} else {
			System.out.println(response.get("error message"));
		}
	}



	void inquireBalanceView(Scanner scanner) {
		System.out.println("Your balance is: " + user.inquireBalance());
	}

	void payBillsView(Scanner scanner) {
		System.out.println("Enter Bill Code:");
		String billCode = scanner.next();

		if(payment.paybill(billCode)){
			System.out.println("Bill paid successfully");
		}
		else{
			System.out.println(response.get("error message"));
		}


	}

	public static void main(String[] args) {
		Instapay instapay = new Instapay();
        instapay.run();
	}


}