import java.util.HashMap;

public class Bank {

	private HashMap<String, Double> clients = new HashMap<>();

	public void setClients(HashMap<String, Double> clients) {
		this.clients = clients;
	}
	public HashMap<String, Double> getClients() {
		return clients;
	}

	public void setClientBalance(String accNum, Double balance) {
		clients.put(accNum, balance);
	}
	public double getClientBalance(String accNum) {
		return clients.get(accNum);
	}
	public boolean containsClient(String accNum) {
		return clients.containsKey(accNum);
	}

}