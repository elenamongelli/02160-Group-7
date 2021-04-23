import Model.LogisticCompany;

public class Facade {
	
	LogisticCompany LogisticCompany = new LogisticCompany();

	public void login(String username, String password) {
		
	}
	
	public void createClient(String name) {
		
		LogisticCompany.newClient(name);
		
	}
	
	public void createContainer() {
		
		LogisticCompany.getClients().get(name).newContainer();
		
	}
	
	public void updateContainerStates(float temp, String pos) {
		
		
		
	}
	
	

	
}
