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
	
	public Client getClient(int index) {
		return logisticCompany.clientManager().getClinets().get(index);
	}

	public ArrayList<Container> getClientContainersByName(String clientName){
		return returnClientByName(clientName).getClientsContainers();
	}
	
	public ArrayList<Container> getClientContainersByEmail(String email){
		return searchClientByMail(email).getClientsContainers();
	}

	public boolean newJourney(String clientName, String origin, String destination, String contend) {
		Container container = logisticCompany.journeyManager().newJourney(origin, destination, contend);
		if (container==null) return false;
		logisticCompany.clientManager().addContainerToClient(clientName, container);
		return true;
	}

	public boolean endJourney(Container container) {
		if(logisticCompany.journeyManager().endJourney(container)) return true;
		return false;
	}

	public void newSensorDataAll(Container container, Float temp, String position, String humidity) {
		logisticCompany.journeyManager().ContainerManager().newSensordata(container, temp, position, humidity);
	}

	public void newSensorDataTemp(Container container, Float temp) {
		newSensorDataAll(container, temp, null, null);
	}

	public void newSensorDataPosition(Container container, String position) {
		newSensorDataAll(container, null, position, null);
	}

	public void newSensorDataHumidity(Container container, String humidity) {
		newSensorDataAll(container, null, null, humidity);
	}

	public void newSensorDataTempPosition(Container container, Float temp, String position) {
		newSensorDataAll(container, temp, position, null);
	}

	public void newSensorDataTempHumidity(Container container, Float temp, String humidity) {
		newSensorDataAll(container, temp, null, humidity);
	}

	public void newSensorDataPositionHumidity(Container container, String position, String humidity) {
		newSensorDataAll(container, null, position, humidity);
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

	public void deleteClient(int i) {
		ArrayList<Container> clientsContainers = new ArrayList<Container>();
		clientsContainers = logisticCompany.clientManager().getClinets().get(i).getClientsContainers();
		for(int j = 0; j<clientsContainers.size(); j++) {
			logisticCompany.journeyManager().endJourney(clientsContainers.get(j));
		}
		logisticCompany.clientManager().getClinets().remove(i);
	}

	public void addViewer(Container container, String owner,String viewer) {
		logisticCompany.clientManager().addViewer(owner, viewer);
		logisticCompany.clientManager().shareContainer(container, viewer);
	}

	public ArrayList<Container> getViewerContainers(String client) {
		return logisticCompany.clientManager().getClientByName(client).getViewerContainers();
		
	}
}
