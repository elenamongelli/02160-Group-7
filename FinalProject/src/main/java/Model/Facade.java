package Model;

import java.util.ArrayList;

public class Facade {

	private LogisticCompany logisticCompany;

	private String ClientName;

	public Facade(LogisticCompany logisticCompany) {
		super();
		this.logisticCompany = logisticCompany;
	}

	public void createClient(String ClientName) {

		this.ClientName = ClientName;
		logisticCompany.newClient(ClientName);

	}

	public void createContainer(String ClientName, String origin) {

		logisticCompany.getClient(ClientName).newContainer(origin);

	}

	public void createContainerWithJourney(String ClientName, String origin, String destination) {

		logisticCompany.getClient(ClientName).newContainer(origin, destination);

	}

	public Boolean newJourney(String ClientName, Container container, String destination) {

		return logisticCompany.getClient(ClientName).newJourney(container, destination);

	}

	public void newJourney(String ClientName, Container container, String origin, String destination) {

		logisticCompany.getClient(ClientName).newJourney(container, origin, destination);

	}

	public void newSensorData(String ClientName, Container container, float temp) {

		logisticCompany.getClient(ClientName).newSensordata(container, temp);

	}

	public ArrayList<Container> getContainers(String ClientName) {

		return logisticCompany.getClient(ClientName).getContainers();

	}

	public Container getContainer(String ClientName, int index) {

		return getContainers(ClientName).get(index);

	}

	public Log getLog(Journey journey) {
		
		return journey.getLog();
		
	}
	
	public Log getLatestLog(Container container) {
		
		return logisticCompany.getClient(ClientName).getLatestLog(container);
		
	}

	public SensorData getLatestSensorData(String ClientName, Container container) {

		return logisticCompany.getClient(ClientName).getLatestSensorData(container);

	}

	public Journey getLatestJourney(String ClientName, Container container) {

		return logisticCompany.getClient(ClientName).getLatestJourney(container);

	}

	public ArrayList<Container> filterContainerByOrigin(ArrayList<Container> containers,String origin) {
		
		ArrayList<Container> filteredContainers = new ArrayList<Container>();
		
		for(Container i : containers) {
			if ()
		}
		
		return null;
	}


}
