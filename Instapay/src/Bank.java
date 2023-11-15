import java.util.HashMap;

public class Bank {

	private HashMap<String, Double> clients = new HashMap<>();

	public void setClients(HashMap<String, Double> clients) {
		this.clients = clients;
	}
	public HashMap<String, Double> getClients() {
		return clients;
	}

	public boolean setClientBalance(String accNum, Double balance) {
		clients.put(accNum, balance);
		return true;
	}
	public double getClientBalance(String accNum) {
		return clients.get(accNum);
	}
	public boolean containsClient(String accNum) {
		if(clients.containsKey(accNum)){
			Instapay.response.put("error message", "Account number not registered.");
			return false;
		}
		else{
			return true;
		}
	}

}