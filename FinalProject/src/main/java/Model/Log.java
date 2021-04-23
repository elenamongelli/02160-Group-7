package Model;

import java.util.ArrayList;


public class Log {
	
	private String errorMessage;

	private ArrayList<SensorData> history;
	

	public Log(String errorMessage, ArrayList<SensorData> history) {
		super();
		this.errorMessage = errorMessage;
		this.history = history;
	}

	public ArrayList<SensorData> getHistory() {
		return history;
	}

	public void addSensorData(SensorData newSonsorData) {
		this.history.add(newSonsorData);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
