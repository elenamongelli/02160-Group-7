package Steps;
import java.util.HashMap;
import java.util.UUID; 

public class Client {
	
	private HashMap<UUID, Container> containers = new HashMap<UUID, Container>();
	
	public HashMap<UUID, Container> getContainers() {
		return containers;
	}


	public void newContainer() {
		
		Container container = new Container();
		
		//is UUID overkill?
		containers.put(UUID.randomUUID(),container);
		
	}
}
