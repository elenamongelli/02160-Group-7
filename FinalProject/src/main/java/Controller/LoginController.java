package Controller;

import Model.UserModel;
import View.LoginView;

public class LoginController {
	
	private ApplicationController application;
	private LoginView view;
	
	public LoginController(ApplicationController application) {
		this.application = application;
		this.view = new LoginView(this);		
	}

	public void checkUserName(String userName) {
		if (userName.equals("Admin")) {
			view.setVisible(false);
			application.manageCompany();
		} else if (UserModel.isClient(userName) == true) {
			view.setVisible(false);
			application.manageClient();
		} else {
			view.WrongLogin();
		}	
	}
	
	public void display() {
		view.setVisible(true);
		
	}

}
