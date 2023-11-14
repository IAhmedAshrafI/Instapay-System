import java.util.HashMap;
import java.util.Map;

public class DB {

	private String name;
	private String password;
	private Map<String, User> walletUsers;
	private Map<String, User> bankUsers;
	private Map<String, Bill> bills;
	private Fawry fawry;
	public Bank bank;
	public WalletProvider walletProvider;
	/**
	 * 
	 * 
	 * @param User
	 */

	public void addUserToDB(User user) {
		if (user instanceof BankAccUser) {
			String name = user.getUsername();
			bankUsers.put(name, user);

		} else if (user instanceof WalletAccUser) {
			String name = user.getUsername();
			walletUsers.put(name, user);
		}

		bankUsers.forEach((key, value) -> System.out.println("Key: " + key + ", User: " + value.getPassword()));
		walletUsers.forEach((key, value) -> System.out.println("Key: " + key + ", User: " + value.getPassword()));

	}

	/**
	 * 
	 * @param username
	 */
	public User getUser(String username) {
		// TODO - implement DB.getUser
		throw new UnsupportedOperationException();
	}

	public boolean checkBUser(String username)
	{
		return bankUsers.containsKey(username);
	}

	public boolean checkWUser(String username)
	{
		return walletUsers.containsKey(username);
	}
}

