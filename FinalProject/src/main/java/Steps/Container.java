package Steps;

public class Container {

	private Log log = new Log();
	
	private Journey journey;
	
	private String origin;
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Log getLog() {
		return log;
	}

	public Journey getJourney() {
		return journey;
	}


	public void newJourney(String destination) {
		this.journey = new Journey(destination,this.origin);
	}

	public Container(String origin) {
		super();
		this.origin = origin;
	}
	
	public Container() {
		super();
	}
}
