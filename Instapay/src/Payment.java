public class Payment {
	public boolean paybill(String billCode) {
		if(!Instapay.db.checkBill(billCode)){
			Instapay.response.put("error message", "Bill code not registered.");
			return false;
		}
		double Price = Instapay.db.getBill(billCode).getPrice();
		if(Instapay.user.getBalance() >= Price){
			Instapay.user.withdraw(Price);
			Instapay.db.deleteBill(billCode);
			return true;
		} else {
			Instapay.response.put("error message", "Insufficient funds");
			return false;
		}
	}

}