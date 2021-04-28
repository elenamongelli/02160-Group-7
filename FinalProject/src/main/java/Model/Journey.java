package Model;
import java.util.UUID;

public class Journey {

	private String destination;
	private String origin;
	private Log log;
	private String content;
	
	private UUID journeyID;
	
	public Journey(String origin, String destination, Log log, String contend, UUID journeyID) {
		super();
		this.destination = destination;
		this.origin = origin;
		this.log = log;
		this.content = contend;
		this.journeyID = journeyID;
	}
	
	public Log getLog() {
		return log;
	}

	public String getDestination() {
		return destination;
	}

	public String getOrigin() {
		return origin;
	}


	public UUID getJourneyID() {
		return journeyID;
	}

	public String getContent() {
		return content;
	}
	
}
