package Model;

public class LogisticCompany {

	private String name;
	
	private LogisticCompanyJourneyManager journeyManager = new LogisticCompanyJourneyManager(); 
	
	private LogisticCompanyClientManager clientManager = new LogisticCompanyClientManager();
	
	public LogisticCompanyJourneyManager journeyManager() {
		return journeyManager;
	}
	
	public LogisticCompanyClientManager clientManager() {
		return clientManager;
	}

	public LogisticCompany(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}	

}
