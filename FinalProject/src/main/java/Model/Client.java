package Model;
import java.util.ArrayList;

import java.util.UUID; 

public class Client {

	private ArrayList<Container> containers = new ArrayList<Container>();

	public ArrayList<Container> getContainers() {
		return containers;
	}

	public Container getContainer(int index) {

		return containers.get(index);

	}

	public void newContainer(String origin) {

		Container newContainer = new Container(new ArrayList<Journey>(), origin, UUID.randomUUID());
		containers.add(newContainer);

	}

	public void newContainer(String origin, String destination) {

		Container newContainer = new Container(new ArrayList<Journey>(), origin, UUID.randomUUID());
		newJourney(newContainer,destination);
		containers.add(newContainer);

	}

	public void newJourney(Container container, String destination) {

		Journey newjourney = new Journey(container.getOrigin(), destination, new Log(new ArrayList<SensorData>()), UUID.randomUUID());
		container.addJourney(newjourney);

	}
	
	public void newJourney(Container container, String origin, String destination) {

		Journey newjourney = new Journey(origin, destination, new Log(new ArrayList<SensorData>()), UUID.randomUUID());
		container.addJourney(newjourney);

	}

	public void newSensordata(Container container, Float temp) {

		SensorData newSensorData = new SensorData(temp);
		container.getLatestJourney().getLog().addSensorData(newSensorData);
	}

	public Log getLog (Journey journey) {
		
		return journey.getLog();
		
	}
	
	public Log getLatestLog(Container container) {
		
		return container.getLatestJourney().getLog();
		
	}
	
	public SensorData getLatestSensorData(Container container) {

		return container.getLatestJourney().getLog().getLatestSensorData();

	}

	public Journey getLatestJourney(Container container) {

		return container.getLatestJourney();

	}

}
