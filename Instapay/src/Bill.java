public abstract class Bill {

	private double price;
	private String code;
	private String clientName;

	public Bill(double price, String code, String clientName) {
		this.price = price;
		this.code = code;
		this.clientName = clientName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public abstract void displayContent();

}