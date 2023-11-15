public abstract class User {
	protected String username;
	protected String password;
	protected String phoneNum;
	protected double balance;
	protected Bill[] bills;

	protected Transfer transferStrategy;
	

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

	public abstract void setTransferStrategy(Transfer transferStrategy);
	public abstract Transfer getTransferStrategy();

	public void setBills(Bill[] bills) {
		this.bills = bills;
	}

	public boolean deposit (double amount) {
		setBalance(getBalance() + amount);
		return true;
	}

	public boolean withdraw (double amount) {

		setBalance(getBalance() - amount);
		return true;
	}

	public boolean transfer(String transferTo, Double amount) {
		if (amount < getBalance()) {
			Instapay.response.put("error message", "Insufficient funds");
			return false;
		}
		if(transferStrategy.transfer(transferTo, amount)){
			return withdraw(amount);
		}
		else{
			Instapay.response.put("error message", "Server is down.");
			return false;
		}
	}
}