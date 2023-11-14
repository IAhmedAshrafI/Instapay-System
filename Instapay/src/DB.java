import java.util.HashMap;
import java.util.Map;

public class DB {

	private String name;
	private String password;
	private Map<String, User> walletUsers;
	private Map<String, User> bankUsers;
	private Map<String, Bill> bills;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPass()
	{
		return password;
	}

	public void setPass(String password)
	{
		this.password = password;
	}

	public DB() {
		walletUsers = new HashMap<>();
		bankUsers = new HashMap<>();
		bills = new HashMap<>();
	}

	/**
	 * 
	 * 
	 * @param User
	 */

	public void addUserToDB(User user) {
		if (user instanceof BankAccUser) {
			String name = user.getUsername();
			setName(user.getUsername());
			setPass(user.getPassword());
			bankUsers.put(name, user);

		} else if (user instanceof WalletAccUser) {
			String name = user.getUsername();
			setName(user.getUsername());
			setPass(user.getPassword());
			walletUsers.put(name, user);
		}

		bankUsers.forEach((key, value) -> System.out.println("Key: " + key + ", User: " + value.getPassword()));

	}

	/**
	 * 
	 * @param username
	 */
	public User getUser(String username) {
	// 	Instapay instapay = new Instapay();
		
	// 	if (walletUsers.containsKey(username)) {

	// 		System.out.println("Holaaa_wallet");
	// 		instapay.setUserType(AccType.WA);
			
	// 		for (Map.Entry<String, User> entry : walletUsers.entrySet()) {
	// 			System.out.println("Holaaa_wallet");
	// 			System.out.println(entry.getKey() + ": " + entry.getValue());
	// 		}
			
	// 		System.out.println(walletUsers.get(username).getPhoneNum());
			
	// 		return walletUsers.get(username);
			
	// 	}else {
	// 		instapay.setUserType(AccType.BA);
	// 		System.out.println("Holaaa_Bank");
	// 		bankUsers.forEach((key, value) -> System.out.println("Key: " + key + ", User: " + value.getPassword()));

	// 	System.out.println(bankUsers.get(username));

	// return bankUsers.get(username);
	}
}

