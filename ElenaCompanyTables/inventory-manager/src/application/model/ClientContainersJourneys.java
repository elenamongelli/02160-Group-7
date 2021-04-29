package application.model;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

public class ClientContainersJourneys extends AbstractTableModel {

	private static final long serialVersionUID = -8100080945080186023L;
	private ArrayList<ClientContainersJourneysRow> clientContainersJourneysRows; 
	
	// Receive argument client information
	public ClientContainersJourneys() {
		clientContainersJourneysRows = new ArrayList<ClientContainersJourneysRow>();
	}
		
	public void addProduct() {		
		clientContainersJourneysRows.add(new ClientContainersJourneysRow("J1","O1","D1","C1","CO1"));
		clientContainersJourneysRows.add(new ClientContainersJourneysRow("J2","O2","D2","C2","CO2"));
		clientContainersJourneysRows.add(new ClientContainersJourneysRow("J3","O3","D3","C3","CO3"));		
		fireTableDataChanged(); // notify the views that data changed
	}

	public void removeProduct(int selectedRow) {		
		clientContainersJourneysRows.remove(selectedRow);		
		fireTableDataChanged(); // notify the views that data changed
	}	
	
	// methods below to extend table model
	
	@Override
	public int getColumnCount() {
		return 5; // this is fixed: product and quantity
	}

	@Override
	public int getRowCount() {
		return clientContainersJourneysRows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {	
		ClientContainersJourneysRow row = clientContainersJourneysRows.get(rowIndex);
		
		if (columnIndex == 0) {
			return row.journeyID;
		} else if (columnIndex == 1) {
			return row.origin;
		} else if (columnIndex == 2) {
			return row.destination;
		} else if (columnIndex == 3) {
			return row.containerID;
		} else if (columnIndex == 4) {
			return row.content;
		}		
		return null;
	}
	
	String[] columnNames = new String[] {"journeyID", "origin", "destination", "containerID", "content"};
		
	@Override
	public String getColumnName(int column) {
		if (column < columnNames.length) {
			return columnNames[column];
		}
		return null;
	}
}
