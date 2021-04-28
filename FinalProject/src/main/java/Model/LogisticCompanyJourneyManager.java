package Model;

import java.util.ArrayList;
import java.util.UUID;

public class LogisticCompanyJourneyManager {

	private LogisticCompanyContainerManager containerManager = new LogisticCompanyContainerManager();

	public LogisticCompanyContainerManager ContainerManager() {
		return containerManager;
	}

	public Container newJourney(String origin, String destination, String contend) {
		if(!newJourneyChecker(origin, destination)) return null;

		Journey newjourney = new Journey(origin, destination, new Log(new ArrayList<SensorData>()), contend, UUID.randomUUID());

		Container container = containerManager.getContainerByOrigin(origin);
		container.addJourney(newjourney);
		container.setOnJourney(true);

		return container;
	}

	private boolean newJourneyChecker(String origin, String destination) {
		if(origin.equals(destination)) return false;
		if(origin.equals(" ")) return false;
		if(destination.equals(" ")) return false;
		return true;
	}

	public boolean endJourney(Container container) {
		if (container.isOnJourney()) {
			String destinationPlaceholder = container.getLatestJourney().getDestination();
			container.setOrigin(destinationPlaceholder);
			container.setOnJourney(false);
			return true;
		}
		return false;
	}

}
