package Steps;

import java.util.ArrayList;


public class Container {

	boolean TempSensor;
	int LowerLimTemp;
	int UpperLimTemp;
	
	ArrayList<Integer> tempHistory = new ArrayList<Integer>(0);
	
	public float getLowerLimTemp() {
		return LowerLimTemp;
	}

	public void setLowerLimTemp(int lowerLimTemp) {
		LowerLimTemp = lowerLimTemp;
	}

	public float getUpperLimTemp() {
		return UpperLimTemp;
	}

	public void setUpperLimTemp(int upperLimTemp) {
		UpperLimTemp = upperLimTemp;
	}

	public boolean isTempSensor() {
		return TempSensor;
	}

	public void setTempSensor(boolean tempSensor) {
		TempSensor = tempSensor;
	}

	void tempReading(int temperature) {
		
		tempHistory.add(temperature);
		
	}

	public int currentTemp() {
		
		int currentTemp = tempHistory.get(tempHistory.size() - 1);
		
		return currentTemp;
	}


	
	
	
}
