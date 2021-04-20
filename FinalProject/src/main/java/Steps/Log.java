package Steps;

import java.util.ArrayList;


public class Log {

	private Float temp;
	
	private String errorMessage = null;

	private ArrayList<Log> history = new ArrayList<Log>();

	public Log() {
		super();
	}

	public String requestHistory(){

		StringBuffer sb = new StringBuffer();

		for (int i=0; i<history.size(); i++) {
			sb.append(history.get(i).getTemp());
			sb.append(" ");
		}
		String history = sb.toString();

		return history;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		if (temp!=null) {
		this.temp = temp;
		} else {
			errorMessage = "sensor not working";
		}
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void set (Float temp) {

		Log measurement = new Log();

		measurement.setTemp(temp);

		history.add(measurement);
	}

	public void clearHistory() {
		
		history.clear();
		
	}





}
