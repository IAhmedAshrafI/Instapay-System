import java.util.HashMap;
import java.util.Scanner;

public class Instapay {

	private Registeration registeration;
	private User user;
	private Payment payment;
	private AccType UserAccType;
	private Authentication authentication;
	private Validation validation;
	public static DB db = new DB();
	private Fawry fawry = new Fawry();
	private CIB cib = new CIB();
	private VodafoneCash vodafoneCash = new VodafoneCash();
	public Bank bank = new Bank();

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
		fawry.setClients(map);
		HashMap <String, Double> vodaMap = new HashMap<>();
		vodaMap.put("01044455531", 50000.0);
		vodaMap.put("01055544431", 20000.0);
		vodafoneCash.setClients(vodaMap);
		HashMap <String, Double> cibMap = new HashMap<>();
		cibMap.put("01244455531", 50000.0);
		cibMap.put("01255544431", 100000.0);
		cib.setClients(cibMap);
	}

	public void run() {

		String name, password, BankNum, phoneNumber, phoneNumber_OTP, OTP_Code;
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
			BankValidation bankValidation = new BankValidation();
			WalletValidation walletValidation = new WalletValidation();
			
			switch (userChoice) {
				case 1:
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
									bankAcc.setBank(bank);
									bankUser.setBankAcc(bankAcc);

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

									User WalletUser = new WalletAccUser();

									WalletUser.setUsername(name);
									WalletUser.setPassword(password);
									WalletUser.setPhoneNum(phoneNumber);

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

	




	private void WalletTesters() {
		// Scanner scanner = new Scanner(System.in);

        // while (true) {
            // System.out.println("Enter a number (1 for fawry 2 for vodafone 3 for cib):");
            // int number = scanner.nextInt();

            // System.out.println("Enter a phone number:");
            // String phoneNumber = scanner.next();

            // // Check if the number matches 1
            // if (number == 1) {
			// 	if(!fawry.containsClient(phoneNumber)) {
			// 		System.out.println("Not found");
			// 	} else {
			// 		System.out.println(fawry.getClientBalance(phoneNumber));
			// 	}
				
            // } 
            // // Check if the number matches 2
            // else if (number == 2) {
            //     if(!vodafoneCash.containsClient(phoneNumber)) {
			// 		System.out.println("Not found");
			// 	} else {
			// 		System.out.println(vodafoneCash.getClientBalance(phoneNumber));
			// 	}
            // } 
            // // Check if the number matches 3
            // else if (number == 3) {
            //     if(!cib.containsClient(phoneNumber)) {
			// 		System.out.println("Not found");
			// 	} else {
			// 		System.out.println(cib.getClientBalance(phoneNumber));
			// 	}
            // } 
            // // Break out of the loop if the number doesn't match 1, 2, or 3
            // else {
            //     System.out.println("Number does not match 1, 2, or 3. Breaking out of the loop.");
            //     break;
            // }

			// // ------------------------------------------------------------------------

        //     System.out.println("Enter a phone number:");
        //     String phoneNumber = scanner.next();

		// 	WalletAcc walletAcc = new WalletAcc();
		// 	System.out.println("Enter a number (1 for fawry 2 for vodafone 3 for cib):");
        //     int number = scanner.nextInt();

		// 	walletAcc.setPhoneNum(phoneNumber);
		// 	if (number == 1) {
		// 		if(fawry.containsClient(phoneNumber)) {
		// 			walletAcc.setWalletProvider(fawry);
		// 		} else {
		// 			System.out.println("Not found");
		// 		}
		// 		System.out.println(walletAcc.getBalance());
        //     } 
        //     // Check if the number matches 2
        //     else if (number == 2) {
        //         if(vodafoneCash.containsClient(phoneNumber)) {
		// 			walletAcc.setWalletProvider(vodafoneCash);
		// 		} else {
		// 			System.out.println("Not found");
		// 		}
		// 		System.out.println(walletAcc.getBalance());
        //     } 
        //     // Check if the number matches 3
        //     else if (number == 3) {
        //         if(cib.containsClient(phoneNumber)) {
		// 			walletAcc.setWalletProvider(cib);
		// 		} else {
		// 			System.out.println("Not found");
		// 		}
		// 		System.out.println(walletAcc.getBalance());
        //     } 

			
		// 	System.out.println("Enter your username:");
		// 	String username = scanner.nextLine();

		// 	System.out.println("Enter your password:");
		// 	String password = scanner.nextLine();

		// 	System.out.println("Enter a phone number:");
        //     String phoneNumber = scanner.next();


		// 	WalletAccUser walletAccUser = new WalletAccUser();
		// 	walletAccUser.setUsername(username);
		// 	walletAccUser.setPassword(password);
		// 	walletAccUser.setPhoneNum(phoneNumber);
		// 	WalletAcc walletAcc = new WalletAcc();

		// 	System.out.println("Enter a number (1 for fawry 2 for vodafone 3 for cib):");
        //     int number = scanner.nextInt();

		// 	 if (number == 1) {
		// 		if(!fawry.containsClient(phoneNumber)) {
		// 			System.out.println("Not found");
		// 		} else {
		// 			walletAcc.setPhoneNum(phoneNumber);
		// 			walletAcc.setWalletProvider(fawry);
		// 			walletAccUser.setWalletAcc(walletAcc);
		// 		}
				
        //     } 
        //     // Check if the number matches 2
        //     else if (number == 2) {
        //         if(!vodafoneCash.containsClient(phoneNumber)) {
		// 			System.out.println("Not found");
		// 		} else {
		// 			walletAcc.setPhoneNum(phoneNumber);
		// 			walletAcc.setWalletProvider(vodafoneCash);
		// 			walletAccUser.setWalletAcc(walletAcc);
		// 		}
        //     } 
        //     // Check if the number matches 3
        //     else if (number == 3) {
        //         if(!cib.containsClient(phoneNumber)) {
		// 			System.out.println("Not found");
		// 		} else {
		// 			walletAcc.setPhoneNum(phoneNumber);
		// 			walletAcc.setWalletProvider(cib);
		// 			walletAccUser.setWalletAcc(walletAcc);
		// 		}
        //     } 
        //     // Break out of the loop if the number doesn't match 1, 2, or 3
        //     else {
        //         System.out.println("Number does not match 1, 2, or 3. Breaking out of the loop.");
        //         break;
        //     }

		// 	System.out.println(walletAccUser.getBalance());


			
        // }


	}

	public static void main(String[] args) {
		Instapay instapay = new Instapay();
        instapay.run();
	}


}