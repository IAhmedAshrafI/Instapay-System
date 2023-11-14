public class GasBill extends Bill {
	public GasBill(double price, String code, String clientName) {
		super(price, code, clientName);
	}

	public void displayContent() {
		String message = "Dear "+ getClientName() +"\nYour gas bill code is "+getCode() +" and the price = "+getPrice();
		System.out.println(message);
	}

}