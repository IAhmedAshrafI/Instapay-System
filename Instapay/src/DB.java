import java.util.HashMap;

public class DB {
	private HashMap<String, WalletAccUser> walletUsers;
	private HashMap<String, BankAccUser> bankUsers;
	private HashMap<String, Bill> bills = new HashMap<>();
	public Fawry fawry = new Fawry();
	public CIB cib = new CIB();
	public VodafoneCash vodafoneCash = new VodafoneCash();
	public Bank bank = new Bank();

//	public DB(){
//		Bill bill1 = new ElecBill(100.00 , "123" ,"Noureen");
//		Bill bill2 = new WaterBill(150.00 , "456" ,"Shahd");
//		Bill bill3 = new GasBill(200.00 , "789" ,"saif");
//		bills.put(bill1.getCode(), bill1);
//		bills.put(bill2.getCode(), bill2);
//		bills.put(bill3.getCode(), bill3);
//		bills.put(Instapay.user.getUsername(), getBill("123"));
//	}
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
		if(!bankUsers.containsKey(username)){
			Instapay.response.put("error message", "User not found");
			return false;
		}
		else {
			return true;
		}
	}

	public boolean checkWUser(String username)
	{
		if(!walletUsers.containsKey(username)){
			Instapay.response.put("error message", "User not found");
			return false;
		}
		else {
			return true;
		}
	}
}

