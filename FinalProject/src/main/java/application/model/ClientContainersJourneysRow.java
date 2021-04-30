package application.model;

public class ClientContainersJourneysRow {
	String journeyID;
	String origin;
	String destination;
	String containerID;
	String content;
	
	public ClientContainersJourneysRow(String journeyID, String origin, String destination, String containerID, String content) {
		this.journeyID = journeyID;
		this.origin = origin;
		this.destination = destination;
		this.containerID = containerID;
		this.content = content;
	}
	
	public void setJourneyID(String journeyID) {
		this.journeyID = journeyID;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setContainerID(String containerID) {
		this.containerID = containerID;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
