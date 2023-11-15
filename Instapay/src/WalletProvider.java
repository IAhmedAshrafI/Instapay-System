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

	public boolean setClientBalance(String phoneNum, Double balance) {
		clients.put(phoneNum, balance);
		return true;
	}


	public boolean containsClient(String phoneNum) {
		if(clients.containsKey(phoneNum)){
			return true;
		}
		else{
			Instapay.response.put("error message", "Phone number not registered.");
			return false;
		}
	}
}