package Model;

import java.util.ArrayList;

public class Client {
	
	private String name;

	private ArrayList<Container> clientsContainers;
	
	public boolean addContainer(Container newContainer) {
		return clientsContainers.add(newContainer);
	}
	
	public boolean removeContainer(Container container) {
		return clientsContainers.remove(container);
	}

	public ArrayList<Container> getClientsContainers() {
		return clientsContainers;
	}

	public Client(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
