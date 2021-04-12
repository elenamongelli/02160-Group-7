package Steps;

import java.util.ArrayList;


public class ContainerStatus {

	String errorMessage;
	
	ArrayList<Float> tempHistory = new ArrayList<Float>();
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public void readTemp(Float float1) {
		tempHistory.add(float1);
		
	}

	float currentTemp() {
		
		return tempHistory.get(tempHistory.size() - 1);
		
	}
	
	
}
