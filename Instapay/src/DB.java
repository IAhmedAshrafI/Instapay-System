import java.util.HashMap;

public class DB {
	private HashMap<String, WalletAccUser> walletUsers = new HashMap<>();
	private HashMap<String, BankAccUser> bankUsers = new HashMap<>();
	private HashMap<String, Bill> bills = new HashMap<>();
	public Fawry fawry = new Fawry();
	public CIB cib = new CIB();
	public VodafoneCash vodafoneCash = new VodafoneCash();
	public Bank bank = new Bank();

	public DB(){
		Bill bill1 = new ElecBill(100.00 , "123" ,"Noureen");
		Bill bill2 = new WaterBill(150.00 , "456" ,"Shahd");
		Bill bill3 = new GasBill(200.00 , "789" ,"saif");
		bills.put(bill1.getCode(), bill1);
		bills.put(bill2.getCode(), bill2);
		bills.put(bill3.getCode(), bill3);
		// bills.put(Instapay.user.getUsername(), getBill("123"));
		HashMap <String, Double> fawryMap = new HashMap<>();
		fawryMap.put("01144455531", 50000.0);
		fawryMap.put("01155544431", 60000.0);
		fawry.setClients(fawryMap);
		HashMap <String, Double> vodaMap = new HashMap<>();
		vodaMap.put("01044455531", 50000.0);
		vodaMap.put("01055544431", 20000.0);
		vodafoneCash.setClients(vodaMap);
		HashMap <String, Double> cibMap = new HashMap<>();
		cibMap.put("01244455531", 50000.0);
		cibMap.put("01255544431", 100000.0);
		cib.setClients(cibMap);

		HashMap <String, Double> bankMap = new HashMap<>();
		bankMap.put("123456789", 50000.0);
		bankMap.put("987654321", 100000.0);
		bank.setClients(bankMap);

		WalletAccUser walletUser = new WalletAccUser();

		walletUser.setUsername("seif2");
		walletUser.setPassword("Seif1234");
		walletUser.setPhoneNum("01244455531");
		WalletAcc walletAcc = new WalletAcc();
		walletAcc.setPhoneNum("01244455531");
		walletAcc.setWalletProvider(cib);
		walletUser.setWalletAcc(walletAcc);

		walletUsers.put("seif2", walletUser);

		BankAccUser bankUser = new BankAccUser();

		bankUser.setUsername("seif3");
		bankUser.setPassword("Seif1234");
		bankUser.setPhoneNum("01044455531");
		BankAcc bankAcc = new BankAcc();
		bankAcc.setAccNum("123456789");
		bankAcc.setBank(bank);
		bankUser.setBankAcc(bankAcc);

		bankUsers.put("seif3", bankUser);

	}

//	public HashMap<String , Bill> billsMap(){
//		Bill bill1 = new ElecBill(100.00 , "123" ,"Noureen");
//		Bill bill2 = new WaterBill(150.00 , "456" ,"Shahd");
//		Bill bill3 = new GasBill(200.00 , "789" ,"saif");
//		bills.put(bill1.getCode(), bill1);
//		bills.put(bill2.getCode(), bill2);
//		bills.put(bill3.getCode(), bill3);
//		return bills;
//	}

	public void addBankUserToDB(BankAccUser user) {
			bankUsers.put(user.getUsername(),user);
	}
	public void addWalletUserToDB(WalletAccUser user) {
		walletUsers.put(user.getUsername(),user);
	}
	public User getUser(String username) {
		if(walletUsers.containsKey(username)){
			return walletUsers.get(username);
		} else if(bankUsers.containsKey(username)){
			return bankUsers.get(username);
		} else{
			return null;
		}
	}
	public Bill getBill(String code){return bills.get(code);}
	public boolean checkBill(String code){
		return bills.containsKey(code);
	}
	public void deleteBill(String code){bills.remove(code);}

	public boolean checkBUser(String username)
	{
		if(bankUsers.containsKey(username)){
			return true;
		}
		else {
			Instapay.response.put("error message", "username not registered.");
			return false;
		}
	}

	public boolean checkWUser(String username)
	{
		if(walletUsers.containsKey(username)){
			return true;
		}
		else {
			Instapay.response.put("error message", "username not registered.");
			return false;
		}
	}
}

