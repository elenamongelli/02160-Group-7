package Model;

import java.util.ArrayList;
import java.util.UUID;

public class LogisticCompanyContainerManager {

	private ArrayList<Container> containers = new ArrayList<Container>();

	public ArrayList<Container> getContainers() {
		return containers;
	}
	
	private void createContainer(String origin) {
		Container newContainer = new Container(new ArrayList<Journey>(), origin, UUID.randomUUID(), false);
		containers.add(newContainer);
	}

	public Container getContainerByOrigin(String origin) {
		for(int i = 0; i<containers.size(); i++) {
			if(!containers.get(i).isOnJourney()) {
				if(containers.get(i).getOrigin().equals(origin)) {
					return containers.get(i);
				}
			}
		}
		createContainer(origin);
		return getContainerByOrigin(origin);
	}
	
	public void newSensordata(Container container, Float temp) {
		newSensordata(container,temp, null, null);
	}
	
	public void newSensordata(Container container, Float temp, String position) {
		newSensordata(container,temp, position, null);
	}
	
	public void newSensordata(Container container, Float temp, String position, String humidity) {
		SensorData newSensorData = new SensorData(temp, position, humidity);
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

