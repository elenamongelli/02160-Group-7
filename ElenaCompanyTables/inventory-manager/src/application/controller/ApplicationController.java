package application.controller;

import application.model.ClientContainersJourneys;
import application.model.Session;
import application.view.ClientContainersJourneysView;

public class ApplicationController {
	
	private LoginController loginController;
	private ClientContainersJourneysController clientContainersJourneysController;
	
	public void manageClientContainers(Session session) {
		clientContainersJourneysController = new ClientContainersJourneysController(new ClientContainersJourneys(), session);

		ClientContainersJourneysView invView = new ClientContainersJourneysView(clientContainersJourneysController);
		clientContainersJourneysController.setView(invView);
		clientContainersJourneysController.display();
	}
	
	public void login() {
		loginController = new LoginController(this);
		loginController.display();
	}
		
	public static void main(String[] args) {
		ApplicationController app = new ApplicationController();
		app.login();
	}
}
