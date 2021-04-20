package Steps;
import java.util.HashMap;

public class LogisticCompany {
	
	HashMap<String, Client> clients = new HashMap<String, Client>();

	public void newClient(String name) {
		
		Client client = new Client();
		
		clients.put(name, client);
		
	}
	
}
