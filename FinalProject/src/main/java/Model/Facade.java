package Model;

import java.util.ArrayList;


public class Facade {

	private LogisticCompany logisticCompany;


	public Facade(LogisticCompany logisticCompany) {
		super();
		this.logisticCompany = logisticCompany;
	}

	public void createClient(String ClientName) {
		logisticCompany.clientManager().newClient(ClientName);
	}


	public boolean newJourney(String ClientName, String origin, String destination) {
		Container container = logisticCompany.journeyManager().newJourney(origin, destination);
		if (container==null) return false;
		logisticCompany.clientManager().addContainerToClient(ClientName, container);
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

	/*
	public ArrayList<Container> filterContainerByOrigin(ArrayList<Container> containers,String origin) {

		ArrayList<Container> filteredContainers = new ArrayList<Container>();

		for(Container i : containers) {
			if ()
		}

		return null;
	}
	 */

}
