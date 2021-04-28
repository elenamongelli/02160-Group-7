package application.model.facades;

import java.util.ArrayList;

import application.model.*;

public class AdminApp {
	
	private static AdminApp instance;
	private AdminApp() {}

	public static AdminApp getInstance() {
		if(instance== null) {
			instance= new AdminApp();
		}
		return instance;
	}
	
	LogisticCompanyClientManager clientManager = LogisticCompanyClientManager.getInstance();
	LogisticCompanyJourneyManager journeyManager = LogisticCompanyJourneyManager.getInstance();
	LogisticCompanyContainerManager containerManager = LogisticCompanyContainerManager.getInstance();

	public void createClient(String clientName, String address, String referencePerson, String email) {
		clientManager.newClient(clientName, address, referencePerson, email);
	}

	public Client searchClientByName(String clintName){
		return clientManager.getClientByName(clintName);
	}

	public Client searchClientByMail(String email) {
		return  clientManager.getClientByEmail(email);
	}
	
	public Client getClient(int index) {
		return clientManager.getClinets().get(index);
	}

	public ArrayList<Container> getClientContainersByName(String clientName){
		return searchClientByName(clientName).getClientsContainers();
	}
	
	public ArrayList<Container> getClientContainersByEmail(String email){
		return searchClientByMail(email).getClientsContainers();
	}
	
	public void updateClientName(String currentClientName, String newClientName) {
		clientManager.updateClientName(currentClientName, newClientName);
	}

	public void updateClientAddress(String currentClientName, String address) {
		clientManager.updateClientAddress(currentClientName, address);
	}

	public void updateClientRefrencePerson(String currentClientName, String refrencePerson) {
		clientManager.updateClientRefrencePerson(currentClientName, refrencePerson);
	}

	public void updateClientEmail(String currentClientName, String email) {
		clientManager.updateClientEmail(currentClientName, email);
	}

	public void deleteClient(int i) {
		ArrayList<Container> clientsContainers = new ArrayList<Container>();
		clientsContainers = clientManager.getClinets().get(i).getClientsContainers();
		for(int j = 0; j<clientsContainers.size(); j++) {
			journeyManager.endJourney(clientsContainers.get(j));
		}
		clientManager.getClinets().remove(i);
	}

	public void addViewer(Container container, String owner,String viewer) {
		clientManager.addViewer(owner, viewer);
		clientManager.shareContainer(container, viewer);
	}

	public ArrayList<Container> getViewerContainers(String client) {
		return clientManager.getClientByName(client).getViewerContainers();
		
	}
	
	public ArrayList<Container> getAllContainers() {
		return containerManager.getContainers();
	}

	public Container getContainer(int index) {
		return getAllContainers().get(index);
	}
	
	public void resetApp() {
		clientManager.getClinets().clear();
		containerManager.getContainers().clear();
	}
}

