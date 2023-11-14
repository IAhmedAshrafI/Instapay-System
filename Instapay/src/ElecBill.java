public class ElecBill extends Bill {
	public ElecBill(double price, String code, String clientName) {
		super(price, code, clientName);
	}

	public void displayContent() {
		String message = "Dear "+ getClientName() +"\nYour electricity bill code is "+getCode() +" and the price = "+getPrice();
		System.out.println(message);
	}

}