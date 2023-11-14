public class WaterBill extends Bill {
	public WaterBill(double price, String code, String clientName) {
		super(price, code, clientName);
	}

	public void displayContent() {
		String message = "Dear "+ getClientName() +"\nYour water bill code is "+getCode() +" and the price = "+getPrice();
		System.out.println(message);
	}
	
}