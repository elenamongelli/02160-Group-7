package application.controller;

import application.model.Session;
import application.model.User;
import application.view.LoginView;

public class LoginController {

	private ApplicationController application;
	private Session session;
	private LoginView view;

	public LoginController(ApplicationController application) {
		this.application = application;
		this.session = new Session();
		this.view = new LoginView(this);
	}

	public void validateCredentials(String username) {
		User user = new User();
		user.setUsername(username);
		System.out.println(username);

		if (username.equals("admin")) {
			session.setUser(user);
			view.setVisible(false);
			application.manageInventory(session);
		} else {
			view.showError();
		}
	}

	public void display() {
		view.setVisible(true);
	}
}
