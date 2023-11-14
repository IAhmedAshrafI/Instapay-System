import java.util.HashMap;
import java.util.Map;

public class DB {
	private HashMap<String, User> walletUsers;
	private HashMap<String, User> bankUsers;
	private HashMap<String, Bill> bills = new HashMap<>();

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
	public void addBankUserToDB(User user) {
			bankUsers.put(user.getUsername(),user);
	}
	public void addWalletUserToDB(User user) {
		walletUsers.put(user.getUsername(),user);
	}
	public User getUser(int username) {
		if(walletUsers.containsKey(username)){
			return walletUsers.get(username);
		} else if(bankUsers.containsKey(username)){
			return bankUsers.get(username);
		} else{
			return null;
		}
	}
	public Bill getBill(String code){return bills.get(code);}
	public void deleteBill(String code){bills.remove(code);}

}