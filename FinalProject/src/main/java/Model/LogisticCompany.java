package Model;
import java.util.HashMap;

public class LogisticCompany {
	
	private String name;
	
	private HashMap<String, Client> clients = new HashMap<String, Client>();

	
	public LogisticCompany(String name) {
		super();
		this.name = name;
	}

	
	public String getName() {
		return name;
	}



	public void newClient(String name) {
		
		Client client = new Client();
		
		clients.put(name, client);
		
	}

	public Client getClient(String Client) {
		return clients.get(Client);
	}
	
}
