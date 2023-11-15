public abstract class User {
	protected String username;
	protected String password;
	protected String phoneNum;
	protected double balance;
	protected Bill[] bills;
	

	public double inquireBalance() {
		return balance;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() { return username;}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() { return password;}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPhoneNum() { return phoneNum;}

	public abstract void setBalance(double balance);

	public abstract double getBalance();

	public void setBills(Bill[] bills) {
		this.bills = bills;
	}

	public void deposit (double amount) {
		setBalance(getBalance() + amount);
	}

	public void withdraw (double amount) {
		setBalance(getBalance() - amount);
	}

	public abstract boolean transfer(String transferTo, Double amount);
}