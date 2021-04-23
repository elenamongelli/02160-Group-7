package Model;

import java.util.ArrayList;


public class Log {
	
	private ArrayList<SensorData> history;

	public Log(ArrayList<SensorData> history) {
		super();
		this.history = history;
	}

	public ArrayList<SensorData> getHistory() {
		return history;
	}
	
	public SensorData getLatestSensorData() {
		return this.history.get(history.size()-1);
	}

	public void addSensorData(SensorData newSonsorData) {
		this.history.add(newSonsorData);
	}

}
