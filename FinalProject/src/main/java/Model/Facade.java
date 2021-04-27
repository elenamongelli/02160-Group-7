package Model;

import java.util.ArrayList;


public class Facade {

	private LogisticCompany logisticCompany = new LogisticCompany();


	public Facade() {
		super();
	}

	public void createClient(String clientName, String address, String referencePerson, String email) {
		logisticCompany.clientManager().newClient(clientName, address, referencePerson, email);
	}

	public Client returnClientByName(String clintName){
		return logisticCompany.clientManager().getClientByName(clintName);
	}
	
	public Client searchClientByMail(String email) {
		return logisticCompany.clientManager().getClientByEmail(email);
	}
	
	public ArrayList<Container> getClientContainersByName(String clientName){
		return returnClientByName(clientName).getClientsContainers();
	}
	public ArrayList<Container> getClientContainersByEmail(String email){
		return searchClientByMail(email).getClientsContainers();
	}
	
	public boolean newJourney(String clientName, String origin, String destination) {
		Container container = logisticCompany.journeyManager().newJourney(origin, destination);
		if (container==null) return false;
		logisticCompany.clientManager().addContainerToClient(clientName, container);
		return true;
	}
	
	public boolean endJourney(Container container) {
		if(logisticCompany.journeyManager().endJourney(container)) return true;
		return false;
	}

	public void newSensorData(Container container, float temp) {
		logisticCompany.journeyManager().ContainerManager().newSensordata(container, temp);
	}

	public ArrayList<Container> getAllContainers() {

		return logisticCompany.journeyManager().ContainerManager().getContainers();

	}

	public Container getContainer(int index) {

		return getAllContainers().get(index);

	}

	public Log getLog(Journey journey) {

		return journey.getLog();

	}

	public Log getLatestLog(Container container) {

		return logisticCompany.journeyManager().ContainerManager().getLatestLog(container);

	}

	public SensorData getLatestSensorData(Container container) {

		return logisticCompany.journeyManager().ContainerManager().getLatestSensorData(container);

	}

	public Journey getLatestJourney(Container container) {

		return logisticCompany.journeyManager().ContainerManager().getLatestJourney(container);

	}
	
	public void updateClientName(String currentClientName, String newClientName) {
		logisticCompany.clientManager().updateClientName(currentClientName, newClientName);
	}
	
	public void updateClientAddress(String currentClientName, String address) {
		logisticCompany.clientManager().updateClientAddress(currentClientName, address);
	}
	
	public void updateClientRefrencePerson(String currentClientName, String refrencePerson) {
		logisticCompany.clientManager().updateClientRefrencePerson(currentClientName, refrencePerson);
	}

	public void updateClientEmail(String currentClientName, String email) {
		logisticCompany.clientManager().updateClientEmail(currentClientName, email);
	}
}
