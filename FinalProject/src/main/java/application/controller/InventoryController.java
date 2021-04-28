package application.controller;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import application.model.*;
import application.model.facades.*;
import application.view.InventoryView;
public class InventoryController {

	private Session sessionModel;
	private InventoryView view;
	AdminApp adminApp = AdminApp.getInstance();
	DataApp dataApp = DataApp.getInstance();
	JourneyApp journeyApp = JourneyApp.getInstance();
	
	public InventoryController(Session session) {
		this.sessionModel = session;
	}

	public void addItem() {
        ArrayList<String> answer = 
        
        //journeyApp.newJourney(clientName, origin, destination, content);
	}

	public void deleteItem(int selectedRow) {
		if (selectedRow >= 0) {
			String productName = (String) inventoryModel.getValueAt(selectedRow, 0);
			inventoryModel.removeProduct(productName);
		}
	}

	public void setView(InventoryView view) {
		this.view = view;
		this.view.setTableModel(inventoryModel);
		this.view.setSession(sessionModel);
	}

	public void display() {
		view.setVisible(true);
	}
}
