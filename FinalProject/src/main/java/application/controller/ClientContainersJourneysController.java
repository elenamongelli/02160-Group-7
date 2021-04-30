package application.controller;

import javax.swing.JOptionPane;

import application.model.ClientContainersJourneys;
import application.model.ContainerHistory;
import application.model.Session;
import application.view.ContainerHistoryView;
import application.view.ClientContainersJourneysView;

public class ClientContainersJourneysController {

	private ClientContainersJourneys clientContainersJourneysModel;
	private Session sessionModel;
	private ClientContainersJourneysView view;
		
	public ClientContainersJourneysController(ClientContainersJourneys clientContainersJourneysModel, Session session) {
		this.clientContainersJourneysModel = clientContainersJourneysModel;
		this.sessionModel = session;			
	}

	public void setView(ClientContainersJourneysView view, String clientName) {
		this.view = view;
		this.view.setTableModel(clientContainersJourneysModel, clientName);
		this.view.setSession(sessionModel);
	}

	public void display() {
		view.setVisible(true);
	}
		
	private ContainerHistoryController containerHistoryController;
	
	public void expandItem(int selectedRow) {
		String containerID = (String) clientContainersJourneysModel.getValueAt(selectedRow, 3);
		
		containerHistoryController = new ContainerHistoryController(new ContainerHistory(containerID), sessionModel);
		ContainerHistoryView inv2View = new ContainerHistoryView(containerHistoryController);
		containerHistoryController.setView(inv2View);		
		
		containerHistoryController.display();
	}

	public void updateField(String newValue, int rowIndex, int colIndex) {
		clientContainersJourneysModel.updateField(newValue, rowIndex, colIndex);
	}
}
