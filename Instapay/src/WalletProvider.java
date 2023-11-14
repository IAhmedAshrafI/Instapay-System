import java.util.HashMap;

public abstract class WalletProvider {
	private HashMap<String, Double> clients = new HashMap<>();

	public HashMap<String, Double> getClients() {
		return clients;
	}

	public void setClients(HashMap<String, Double> clients) {
		this.clients = clients;
	}

	public double getClientBalance(String phoneNum) {
		return clients.get(phoneNum);
	}

	public double setClientBalance(String phoneNum, Double balance) {
		return clients.put(phoneNum, balance);
	}


	public boolean containsClient(String phoneNum) {
		return clients.containsKey(phoneNum);
	}
}