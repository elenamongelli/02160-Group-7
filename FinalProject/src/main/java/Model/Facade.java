package Model;

import java.util.ArrayList;

public class Facade {

	private LogisticCompany logisticCompany;

	private String ClientName;

	public Facade(LogisticCompany logisticCompany) {
		super();
		this.logisticCompany = logisticCompany;
	}

	public void login(String username, String password) {

	}

	public void createClient(String ClientName) {

		this.ClientName = ClientName;
		logisticCompany.newClient(ClientName);

	}

	public void createContainer(String origin) {

		logisticCompany.getClient(this.ClientName).newContainer(origin);

	}

	public void createContainerWithJourney(String origin, String destination) {

		logisticCompany.getClient(this.ClientName).newContainer(origin, destination);

	}

	public void newJourney(Container container, String destination) {

		logisticCompany.getClient(this.ClientName).newJourney(container, destination);

	}

	public void newJourney(Container container, String origin, String destination) {

		logisticCompany.getClient(this.ClientName).newJourney(container, origin, destination);

	}

	public void newSensorData(Container container, float temp) {

		logisticCompany.getClient(this.ClientName).newSensordata(container, temp);

	}

	public ArrayList<Container> getContainers() {

		return logisticCompany.getClient(this.ClientName).getContainers();

	}

	public Container getContainer(int index) {

		return getContainers().get(index);

	}

	public Log getLog(Journey journey) {
		
		return journey.getLog();
		
	}
	
	public Log getLatestLog(Container container) {
		
		return logisticCompany.getClient(ClientName).getLatestLog(container);
		
	}

	public SensorData getLatestSensorData(Container container) {

		return logisticCompany.getClient(this.ClientName).getLatestSensorData(container);

	}

	public Journey getLatestJourney(Container container) {

		return logisticCompany.getClient(this.ClientName).getLatestJourney(container);

	}


}
