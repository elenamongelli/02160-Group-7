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
	
	//setters
	public void setJourneyID(String journeyID) {
		this.journeyID = journeyID;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	
	
}
