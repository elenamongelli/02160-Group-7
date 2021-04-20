package Steps;

import static org.junit.Assert.*;
import java.util.UUID; 

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions{

	Container container;
	ContainerLog containerLog;
	String actualAnswer;
	
	
	UUID id;
	
	
	LogisticCompany LogisticCompany;
	
	@Given("a logistic company have a client {string}")
	public void a_logistic_company_have_a_client(String name) {
	   
		LogisticCompany = new LogisticCompany();
		
		LogisticCompany.newClient(name);
		
		
	}
	
	@Given("the client {string} have a container")
	public void the_client_have_a_container(String name) {
	    
		LogisticCompany.clients.get(name).newContainer();
		id = LogisticCompany.clients.get(name).containers.keySet();
		
	}
	
	@When("the container is reading a temperature of {float} C°")
	public void the_container_is_reading_a_temperature_of_c(Float float1) {
	    
		
	}


	@When("reading a temperature of {float} C°")
	public void reading_a_temperature_of_c(Float float1) {
		// Write code here that turns the phrase above into concrete actions
		container.setTemp(float1);
	}
	@Then("display the temperature of {float} C°")
	public void display_the_temperature_of_c(Float float1) {

		assertEquals(container.getTemp(),float1);
	}

	@When("not reading a temperature")
	public void not_reading_a_temperature() {

		container.setTemp(null);

	}
	@Then("display a message that the sensor is not working {string}")
	public void display_a_message_that_the_sensor_is_not_working(String string) {

		assertEquals(container.getErrorMessage(),string);

	}
	
	@Then("display the message until checked")
	public void display_the_message_until_checked() {

		container.setErrorMessage(null);
		assertEquals(container.getErrorMessage(),null);

	}
	 

	@Given("a container with a history of {float} C°, {float} C°, {float} C°, {float} C°")
	public void a_container_with_a_history_of_c_c_c_c(Float float1, Float float2, Float float3, Float float4) {
		container = new ContainerLog();
		container.set(float1);
		container.set(float2);
		container.set(float3);
		container.set(float4);

	}

	@When("reading a request for history display")
	public void reading_a_request_for_history_display() {

		actualAnswer=container.requestHistory();

	}
	
	@Then("display the history of {float} C°, {float} C°, {float} C°, {float} C°")
	public void display_the_history_of_c_c_c_c(Float float1, Float float2, Float float3, Float float4) {
	 
		String expectedAnswer = String.valueOf(float1) + " " + String.valueOf(float2) + " " + String.valueOf(float3) + " " + String.valueOf(float4) + " ";   
		
		assertEquals(actualAnswer,expectedAnswer);
		
	}


}