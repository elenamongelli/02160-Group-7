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
}
