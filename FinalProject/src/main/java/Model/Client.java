package Model;

import java.util.ArrayList;

public class Client {
	
	private String name;

	private ArrayList<Container> clientsContainers;

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
