package application.controller;

import javax.swing.JOptionPane;


import application.model.*;
import application.model.facades.AdminApp;
import application.view.*;

public class InventoryController {

	private Session sessionModel;
	private InventoryView view;
	private NewClientView newClientView;
	
	public InventoryController(Session session) {
		this.sessionModel = session;
	}

	public void addItem() {
        String newProduct = JOptionPane.showInputDialog("Please insert the item you want to add to inventory:");
        //inventoryModel.addProduct(newProduct);
	}

	public void deleteItem(int selectedRow) {
		if (selectedRow >= 0) {
			//String productName = (String) inventoryModel.getValueAt(selectedRow, 0);
			//inventoryModel.removeProduct(productName);
		}
	}

	public void setView(InventoryView view) {
		this.view = view;
		this.view.setSession(sessionModel);
		this.view.setTableModel(AdminApp.getInstance());
	}
	
	public void changePage() {
		view.setVisible(false);
	}

	public void display() {
		view.setVisible(true);
	}
	
	private ClientContainersJourneysController clientContainersJourneysController;
	
	public void manageClientContainers() {
		clientContainersJourneysController = new ClientContainersJourneysController(new ClientContainersJourneys(), sessionModel);

		ClientContainersJourneysView invView = new ClientContainersJourneysView(clientContainersJourneysController);
		clientContainersJourneysController.setView(invView);
		clientContainersJourneysController.display();
	}
}
