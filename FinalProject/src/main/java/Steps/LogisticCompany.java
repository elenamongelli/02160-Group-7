package Steps;
import java.util.HashMap;

public class LogisticCompany {
	
	private HashMap<String, Client> clients = new HashMap<String, Client>();

	public void newClient(String name) {
		
		Client client = new Client();
		
		clients.put(name, client);
		
	}

	public HashMap<String, Client> getClients() {
		return clients;
	}
	
}
