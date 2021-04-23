package Model;

import java.util.ArrayList;

public class Facade {

	private LogisticCompany logisticCompany;
	private String ClientName;

	public Facade(LogisticCompany logisticCompany) {
		super();
		this.logisticCompany = logisticCompany;
	}

	public void login(String username, String password) {

	}

	public void createClient(String ClientName) {

		this.ClientName = ClientName;
		logisticCompany.newClient(ClientName);

	}

	public void createContainer(String origin) {

		logisticCompany.getClients().get(this.ClientName).newContainer(origin);

	}

	public void createContainerWithJourney(String origin, String destination) {

		logisticCompany.getClients().get(this.ClientName).newContainer(origin, destination);

	}
	
	public void updateContainerStates(Container container, float temp) {

		logisticCompany.getClients().get(this.ClientName).newSensordata(container, temp);
		
	}


	public ArrayList<Container> getContainers() {
		return logisticCompany.getClients().get(ClientName).getContainers();
	}

	



}
