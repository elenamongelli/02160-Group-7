package Model;
import java.util.UUID;

public class Journey {

	private String destination;
	private String origin;
	private Log log;
	
	private UUID journeyID;
	
	public Journey(String origin, String destination, Log log, UUID journeyID) {
		super();
		this.destination = destination;
		this.origin = origin;
		this.log = log;
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
	
}
