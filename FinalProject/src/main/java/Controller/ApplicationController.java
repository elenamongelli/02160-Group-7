package Controller;

import Model.ClientModel;
import Model.CompanyModel;
import View.ClientView;
import View.CompanyView;

public class ApplicationController {
	
	private LoginController loginController;
	private ClientController clientController;
	private CompanyController companyController;

	public void manageClient() {
		clientController = new ClientController(new ClientModel());
		
		ClientView clientView = new ClientView(clientController);
		clientController.setView(clientView);
		clientController.display();
		
	}
	public void manageCompany() {
		companyController = new CompanyController(new CompanyModel());
		
		CompanyView companyView = new CompanyView(companyController);
		companyController.setView(companyView);
		companyController.display();
		
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
