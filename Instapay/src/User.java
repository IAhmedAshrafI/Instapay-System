public abstract class User {

	private String username;
	private String password;
	private String phoneNum;
	private String Type;
	private double balance;
	private Bill[] bills;


	public User(String username, String password, String phoneNum, String type, double balance, Bill[] bills) {
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.balance = balance;
        this.bills = bills;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

	public double inquireBalance() {
		// TODO - implement User.inquireBalance
		throw new UnsupportedOperationException();
	}

	public void operation() {
		// TODO - implement User.operation
		throw new UnsupportedOperationException();
	}


	public void put(String name, User user) {
	}

}