public class BankAccUser extends User {

	private BankAccTransfer transferStrategy;
	private BankAcc bankAcc;
	private User user;

	public BankAccUser(String username, String password, String phoneNum, String type, double balance, Bill[] bills,
			BankAccTransfer transferStrategy, BankAcc bankAcc) {
		super(username, password, phoneNum, type, balance, bills);
		this.transferStrategy = transferStrategy;
		this.bankAcc = bankAcc;
	}

	// public String getUsername() {
	// return this.user.getUsername();
	// }

	// public void setUsername(String username) {
	// this.user.setUsername(username);
	// }

	// public String getPassword() {
	// return this.user.getPassword();
	// }

	// public void setPassword(String password) {
	// this.user.setPassword(password);
	// }

	// public String getPhoneNum() {
	// return this.user.getPhoneNum();
	// }

	// public void setPhoneNum(String phoneNum) {
	// this.user.setPhoneNum(phoneNum);
	// }

	public void operation() {
		// TODO - implement BankAccUser.operation
		throw new UnsupportedOperationException();
	}

}