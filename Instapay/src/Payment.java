public class Payment {
	public boolean paybill(String billCode) {
		double Price = Instapay.db.getBill(billCode).getPrice();
		if(Instapay.user.getBalance() >= Price){
			Instapay.user.withdraw(Price);
			Instapay.db.deleteBill(billCode);
			return true;
		} else {
			return false;
		}
	}

}