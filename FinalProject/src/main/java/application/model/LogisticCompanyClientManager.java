package application.model;

import java.util.ArrayList;
import java.util.UUID;


public class LogisticCompanyClientManager {
	
	// --- singleton---------------
	private static LogisticCompanyClientManager instance;
	
	private LogisticCompanyClientManager() {
	// Generate default clients	
		clients.add(new Client("C1", "A1", "R1", "E1", UUID.randomUUID()));
		clients.add(new Client("C2", "A2", "R2", "E2", UUID.randomUUID()));
		clients.add(new Client("C3", "A3", "R3", "E3", UUID.randomUUID()));
	}

	public static LogisticCompanyClientManager getInstance() {
		if(instance== null) {
			instance= new LogisticCompanyClientManager();
		}
		return instance;
	}
	// --- singleton---------------
	
	private ArrayList<Client> clients = new ArrayList<Client>();

	public void newClient(String clientName, String address, String referencePerson, String email) {
		Client client = new Client(clientName, address, referencePerson, email, UUID.randomUUID());
		clients.add(client);
	}
	
	public ArrayList<Client> getClinets() {
		return clients;
	}

	public Client getClientByName(String client) {
		Client placeholder = null;

		for(int i = 0; i < clients.size(); i++) {
			if(clients.get(i).getName().equals(client)) placeholder = clients.get(i);
		}
		return placeholder;
	}

	public Client getClientByEmail(String email) {
		Client placeholder = null;

		for(int i = 0; i < clients.size(); i++) {
			if(clients.get(i).getEmail().equals(email)) placeholder = clients.get(i);
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

	public void deleteClient(int i) {
		clients.remove(i);
	}

	public void updateClientName(String currentClientName, String newClientName) {
		getClientByName(currentClientName).setName(newClientName);
	}

	public void updateClientAddress(String currentClientName, String address) {
		getClientByName(currentClientName).setAddress(address);
	}

	public void updateClientRefrencePerson(String currentClientName, String refrencePerson) {
		getClientByName(currentClientName).setReferencePerson(refrencePerson);
	}

	public void updateClientEmail(String currentClientName, String email) {
		getClientByName(currentClientName).setEmail(email);
	}

	public void addViewer(String owner, String viewer) {
		getClientByName(owner).addViewer(getClientByName(viewer));
	}
	
	public void shareContainer(Container container, String viewer) {
		getClientByName(viewer).addViewerContainers(container);
	}
}
