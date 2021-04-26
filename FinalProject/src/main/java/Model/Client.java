package Model;

import java.util.ArrayList;
import java.util.UUID;

public class Client {
	
	private String clientName;
	private String email;
	private String address;
	private String referencePerson;
	private UUID clientID;

	private ArrayList<Container> clientsContainers = new ArrayList<Container>();
	
	public Client(String clientName, String address, String referencePerson, String email, UUID clientID) {
		super();
		this.clientName = clientName;
		this.email = email;
		this.address = address;
		this.referencePerson = referencePerson;
		this.clientID = clientID;
	}

	public boolean addContainer(Container newContainer) {
		return clientsContainers.add(newContainer);
	}
	
	public boolean removeContainer(Container container) {
		return clientsContainers.remove(container);
	}

	public ArrayList<Container> getClientsContainers() {
		return clientsContainers;
	}

	public String getName() {
		return clientName;
	}

	public void setName(String name) {
		this.clientName = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReferencePerson() {
		return referencePerson;
	}

	public void setReferencePerson(String referencePerson) {
		this.referencePerson = referencePerson;
	}

	public UUID getClientID() {
		return clientID;
	}

	public void setClientsContainers(ArrayList<Container> clientsContainers) {
		this.clientsContainers = clientsContainers;
	}
	
	

}
