package Steps;
import java.util.UUID;

public class Journey {

	String destination;
	String origin;
	
	UUID journeyID = UUID.randomUUID();
	
	public Journey(String destination, String origin) {
		super();
		this.destination = destination;
		this.origin = origin;
	}
	
	
	
}
