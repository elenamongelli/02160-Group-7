package Steps;

import java.util.ArrayList;


public class ContainerLog {

	Float temp;
	
	String errorMessage = null;

	ArrayList<ContainerLog> history = new ArrayList<ContainerLog>();

	public ContainerLog() {
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

		ContainerLog measurement = new ContainerLog();

		measurement.setTemp(temp);

		history.add(measurement);
	}







}
