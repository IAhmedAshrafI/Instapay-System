public abstract class User {
	protected String username;
	protected String password;
	protected String phoneNum;
	protected double balance;
	protected Bill[] bills;

	public double inquireBalance() {
		// TODO - implement User.inquireBalance
		throw new UnsupportedOperationException();
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public abstract void setBalance(double balance);
	
	public void setBills(Bill[] bills) {
		this.bills = bills;
	}


}