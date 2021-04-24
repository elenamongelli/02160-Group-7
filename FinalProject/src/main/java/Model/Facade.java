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

	public void createContainer(String origin) {

		logisticCompany.newContainer(origin);

	}

	public void createContainerWithJourney(String origin, String destination) {

		logisticCompany.newContainer(origin, destination);

	}

	public Boolean newJourney(Container container, String destination) {

		return logisticCompany.newJourney(container, destination);

	}

	public void newJourney(Container container, String origin, String destination) {

		logisticCompany.newJourney(container, origin, destination);

	}

	public void newSensorData(Container container, float temp) {

		logisticCompany.newSensordata(container, temp);

	}

	public ArrayList<Container> getContainers() {

		return logisticCompany.getContainers();

	}

	public Container getContainer(int index) {

		return getContainers().get(index);

	}

	public Log getLog(Journey journey) {
		
		return journey.getLog();
		
	}
	
	public Log getLatestLog(Container container) {
		
		return logisticCompany.getLatestLog(container);
		
	}

	public SensorData getLatestSensorData(Container container) {

		return logisticCompany.getLatestSensorData(container);

	}

	public Journey getLatestJourney(Container container) {

		return logisticCompany.getLatestJourney(container);

	}

	public ArrayList<Container> filterContainerByOrigin(ArrayList<Container> containers,String origin) {
		
		ArrayList<Container> filteredContainers = new ArrayList<Container>();
		
		for(Container i : containers) {
			if ()
		}
		
		return null;
	}


}
