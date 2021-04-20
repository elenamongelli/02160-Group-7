package Steps;

public class Container {

	private Log log = new Log();
	
	private Journey journey;
	
	private String origin;
	
	public Log getLog() {
		return log;
	}

	public Journey getJourney() {
		return journey;
	}


	public void newJourney(String destination) {
		this.journey = new Journey(this.origin,destination);
	}

	public Container(String origin) {
		super();
		this.origin = origin;
	}
	
}
