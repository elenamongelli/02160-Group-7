package Controller;

import Model.CompanyModel;
import View.CompanyView;

public class CompanyController {
	
	private CompanyView view;
	private ApplicationController controller;

	public CompanyController(CompanyModel companyModel) {
		// TODO Auto-generated constructor stub
	}

	public void setView(CompanyView companyView) {
		// TODO Auto-generated method stub
		
	}

	public void display() {
		// TODO Auto-generated method stub
		
	}

	public void popupRegisterClient() {
		// TODO Auto-generated method stub
		
	}

	public void popupFindInfo() {
		// TODO Auto-generated method stub
		
	}

	public void logout() {
		view.setVisible(false);
		controller.login();
	}

}
