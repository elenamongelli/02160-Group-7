package Model;

public class LogisticCompany {

	
	private LogisticCompanyJourneyManager journeyManager = new LogisticCompanyJourneyManager(); 
	
	private LogisticCompanyClientManager clientManager = new LogisticCompanyClientManager();
	
	public LogisticCompanyJourneyManager journeyManager() {
		return journeyManager;
	}
	
	public LogisticCompanyClientManager clientManager() {
		return clientManager;
	}

	public LogisticCompany() {
		super();
	}

}
