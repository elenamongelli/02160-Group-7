package Model;

public class SensorData {

	private Float temp;
	
	private String position;
	
	private String humidity;
	
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

	public SensorData(Float temp, String position, String humidity) {
		super();
		this.temp = temp;
		this.position = position;
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		
		return temp.toString();
	}
	
	
	
}
