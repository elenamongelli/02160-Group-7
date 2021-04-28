package Model;

public class SensorData {

	private Float temp;
	
	private String position;
	
	private String humidity;
	
	private String timeStamp;
	
	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public SensorData(Float temp, String position, String humidity, String timeStamp) {
		super();
		this.temp = temp;
		this.position = position;
		this.humidity = humidity;
		this.timeStamp = timeStamp;
	}
	
}
