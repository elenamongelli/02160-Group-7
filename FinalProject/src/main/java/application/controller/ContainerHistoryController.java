package application.controller;

import javax.swing.JTextField;

import application.model.ClientContainersJourneys;
import application.model.ContainerHistory;
import application.model.Session;
import application.view.ContainerHistoryView;
import application.view.ClientContainersJourneysView;

public class ContainerHistoryController {
	
	private ContainerHistory containerHistoryModel;
	private Session sessionModel;
	private ContainerHistoryView view;

	public ContainerHistoryController(ContainerHistory containerHistory, Session session) {		
		this.containerHistoryModel = containerHistory;
		this.sessionModel = session;
	}

	public void setView(ContainerHistoryView view) {
		this.view = view;
		this.view.setTableModel(containerHistoryModel, containerHistoryModel.getContainerID());
		this.view.setSession(sessionModel);
	}
		
	public void addHistoryRowController(String journeyID, String date, String position, String temperature, String humidity, String pressure) {	
		containerHistoryModel.addContainerHistoryRow(journeyID, date, position, temperature, humidity, pressure);
	}
	
	public void removeHistoryRowController(int selectedRow) {
		if (selectedRow >= 0) {
			containerHistoryModel.removeContainerHistoryRow(selectedRow);
		}
	}	
	
	public void display() {	
		view.setVisible(true);		
	}
	
	public void updateField(String newValue, int rowIndex, int colIndex) {
		containerHistoryModel.updateField(newValue, rowIndex, colIndex);
	}
}
