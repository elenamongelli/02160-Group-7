package Model;

import java.util.ArrayList;
import java.util.UUID;

public class LogisticCompanyClientManager {
	
	private ArrayList<Client> clients = new ArrayList<Client>();
	
	public void newClient(String clientName, String address, String referencePerson, String email) {
		Client client = new Client(clientName, address, referencePerson, email, UUID.randomUUID());
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
	
	public void updateClientName(String currentClientName, String newClientName) {
		getClient(currentClientName).setName(newClientName);
	}
	
	public void updateClientAddress(String currentClientName, String address) {
		getClient(currentClientName).setAddress(address);
	}
	
	public void updateClientRefrencePerson(String currentClientName, String refrencePerson) {
		getClient(currentClientName).setReferencePerson(refrencePerson);
	}
	
	public void updateClientEmail(String currentClientName, String email) {
		getClient(currentClientName).setEmail(email);
	}
}
