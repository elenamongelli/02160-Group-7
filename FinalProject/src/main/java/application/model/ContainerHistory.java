package application.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ContainerHistory extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	String containerID;

	private ArrayList<ContainerHistoryRow> containerHistoryRows; 
		
	public ContainerHistory(String containerID) {
		containerHistoryRows = new ArrayList<ContainerHistoryRow>();
		// With a DB these information would be retrieved from it
		this.containerID = containerID;
		containerHistoryRows.add(new ContainerHistoryRow("J0","D0","P0","T0","H0","PR0"));
		containerHistoryRows.add(new ContainerHistoryRow("J1","D2","P2","T2","H2","PR2"));
		containerHistoryRows.add(new ContainerHistoryRow("J2","D3","P3","T3","H3","PR3"));
	}
	
	public String getContainerID() {
		return containerID;
	}
	
	public void addContainerHistoryRow(String journeyID, String date, String position, String temperature, String humidity, String pressure) {	
		containerHistoryRows.add(new ContainerHistoryRow(journeyID, date, position, temperature, humidity, pressure));
		fireTableDataChanged(); // notify the views that data changed
	}
	
	public void removeContainerHistoryRow(int selectedRow) {		
		containerHistoryRows.remove(selectedRow);		
		fireTableDataChanged(); // notify the views that data changed
	}
		
	// methods below to extend table model
	
	@Override
	public int getColumnCount() {
		return 6; // this is fixed: product and quantity
	}

	@Override
	public int getRowCount() {
		return containerHistoryRows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {	
		ContainerHistoryRow row = containerHistoryRows.get(rowIndex);
		
		if (columnIndex == 0) {
			return row.journeyID;
		} else if (columnIndex == 1) {
			return row.date;
		} else if (columnIndex == 2) {
			return row.position;
		} else if (columnIndex == 3) {
			return row.temperature;
		} else if (columnIndex == 4) {
			return row.humidity;
		} else if (columnIndex == 5) {
			return row.pressure;
		}
		
		return null;
	}
		
	String[] columnNames = new String[] {"journeyID", "date", "position", "temperature", "humidity", "pressure"};
	
	@Override
	public String getColumnName(int column) {
		if (column < columnNames.length) {
			return columnNames[column];
		}
		return null;
	}
	
	public void updateField(String newValue, int rowIndex, int colIndex) {
		ContainerHistoryRow row = containerHistoryRows.get(rowIndex);		
		if (colIndex == 0) {
			row.setJourneyID(newValue);
		} else if (colIndex == 1) {
			row.setDate(newValue);
		} else if (colIndex == 2) {
			row.setPosition(newValue);
		} else if (colIndex == 3) {
			row.setTemperature(newValue);
		} else if (colIndex == 4) {
			row.setHumidity(newValue);
		} else if (colIndex == 5) {
			row.setPressure(newValue);
		}		
		fireTableDataChanged(); // notify the views that data changed
	}
}
