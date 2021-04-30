package application.controller;

import application.model.Session;
import application.view.ClientsManagementView;

public class ApplicationController {
	
	private LoginController loginController;
	private ClientsManagementController clientsManagementController;
	
	public void manageInventory(Session session) {
		clientsManagementController = new ClientsManagementController(session);

		ClientsManagementView invView = new ClientsManagementView(clientsManagementController);
		clientsManagementController.setView(invView);
		clientsManagementController.display();
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
