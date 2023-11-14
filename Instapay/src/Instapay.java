import java.util.HashMap;
import java.util.Scanner;

public class Instapay {

	private Registeration registeration;
	private static User user;
	private Payment payment;
	private AccType UserAccType;
	private Authentication authentication;
	public static DB db = new DB();
	private Fawry fawry = new Fawry();
	private CIB cib = new CIB();
	private VodafoneCash vodafoneCash = new VodafoneCash();

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
		System.out.println("Hello");
		WalletTesters();
		
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