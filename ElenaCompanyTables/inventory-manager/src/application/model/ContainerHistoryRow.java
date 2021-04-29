package application.model;

public class ContainerHistoryRow {
	String journeyID;
	String date;
	String position;
	String temperature;
	String humidity;
	String pressure;
	
	public ContainerHistoryRow(String journeyID, String date, String position, String temperature, String humidity,
			String pressure) {
		this.journeyID = journeyID;
		this.date = date;
		this.position = position;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}	
}
