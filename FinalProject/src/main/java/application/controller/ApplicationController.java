package application.controller;

import application.model.Session;
import application.view.ClientsManagementView;

public class ApplicationController {
	
	private LoginController loginController;
	private ClientsManagementController inventoryController;
	
	public void manageInventory(Session session) {
		inventoryController = new ClientsManagementController(session);

		ClientsManagementView invView = new ClientsManagementView(inventoryController);
		inventoryController.setView(invView);
		inventoryController.display();
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
