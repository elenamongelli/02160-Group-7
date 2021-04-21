package Steps;
import java.util.UUID;

public class Journey {

	private String destination;
	private String origin;
	
	private UUID journeyID = UUID.randomUUID();
	
	public Journey(String destination, String origin) {
		super();
		this.destination = destination;
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public UUID getJourneyID() {
		return journeyID;
	}

	public void setJourneyID(UUID journeyID) {
		this.journeyID = journeyID;
	}
	
	
	
}
