package Model;

import java.util.ArrayList;

public class LogisticCompanyClientManager {
	
	private ArrayList<Client> clients = new ArrayList<Client>();
	
	public void newClient(String name) {
		Client client = new Client(name);
		clients.add(client);
	}

	public Client getClient(String client) {
		Client placeholder = null;

		for(int i = 0; i < clients.size(); i++) {
			if(clients.get(i).getName().equals(client)) placeholder = clients.get(i);
		}
		return placeholder;
	}

	public boolean addContainerToClient(String clientName, Container container) {
		Client client = null;
		for(int i = 0; i<clients.size(); i++) {
			if(clients.get(i).getName().equals(clientName)) client = clients.get(i);
		}
		if(client==null) return false;
		client.addContainer(container);
		return true;
	}
}
