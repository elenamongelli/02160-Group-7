package Steps;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions{
	
	Container container = new Container();
	
	@Given("a container has a temperature sensor (true|false)$")
	public void a_container_has_a_temperature_sensor(boolean TempSensor) {
		
		container.setTempSensor(TempSensor);
	}
	@Given("the temperature is within {int} C° to {int} C°")
	public void the_temperature_is_within_c_to_c(Integer int1, Integer int2) {
		
		container.setUpperLimTemp(int1);
		container.setLowerLimTemp(int2);
		
	}
	@When("reading a temperature of {int} C°")
	public void reading_a_temperature_of_c(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("display the temperature of {int} C°")
	public void display_the_temperature_of_c(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	/*
	
	
	@Given("a container has a temperature sensor (true|false)$")
	public void a_container_has_a_temperature_sensor(boolean TempSensor) {
	    
		
		
	}
	@Given("the temperature is within {float} C° to {float} C°")
	public void the_temperature_is_within_c_to_c(float float1, float float2) {
	   
		
		
	}
	@When("reading a temperature of {float} C°")
	public void reading_the_temperature_c(float float1) {
	    
		container.tempReading(float1);
		
	}
	@Then("display the temperature of {float} C°")
	public void display_the_temperature_of_c(float float1) {
	 
		assertTrue(float1==container.currentTemp());
		
	}	
	
	@Given("a container has a temperature sensor")
	public void a_container_has_a_temperature_sensor() {
		
		container.setTempSensor(TempSensor);
	}
	@Given("the temperature is within {int} C° to {int} C°")
	public void the_temperature_is_within_c_to_c(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("reading a temperature of {int} C°")
	public void reading_a_temperature_of_c(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("display the temperature of {int} C°")
	public void display_the_temperature_of_c(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	*/
}