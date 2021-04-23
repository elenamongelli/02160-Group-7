package Steps;

import static org.junit.Assert.*;
import java.util.UUID;

import Model.Container;
import Model.Log;
import Model.LogisticCompany;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions{

	Container container;
	Log containerLog;
	String actualAnswer;
	
	LogisticCompany LogisticCompany;
	
	@Given("a logistic company have a client {string}")
	public void a_logistic_company_have_a_client(String name) {
	   
		LogisticCompany = new LogisticCompany();
		
		LogisticCompany.newClient(name);
		
	}
	
	@Given("the client {string} have a container")
	public void the_client_have_a_container(String name) {
		
		//The following logic is to get the container object in order to access it easier
		LogisticCompany.getClients().get(name).newContainer("Copenhagen");
		container = LogisticCompany.getClients().get(name).getContainers().get(0);
		
	}
	
	@When("the container is reading a temperature of {float} C°")
	public void the_container_is_reading_a_temperature_of_c(Float float1) {
	    
		
		container.getLog().setTemp(float1);
		
	}

	@Then("display the temperature of {float} C°")
	public void display_the_temperature_of_c(Float float1) {

		assertEquals(container.getLog().getTemp(),float1);
	}

	@When("the container is not reading a temperature")
	public void the_container_is_not_reading_a_temperature() {
	    
		container.getLog().setTemp(null);
		
	}
	
	@Then("display a message that the sensor is not working {string}")
	public void display_a_message_that_the_sensor_is_not_working(String string) {

		assertEquals(container.getLog().getErrorMessage(),string);

	}
	
	@Then("display the message until checked")
	public void display_the_message_until_checked() {

		container.getLog().setErrorMessage(null);
		assertEquals(container.getLog().getErrorMessage(),null);

	}
	 
	
	@Given("the container have a history of {float} C°, {float} C°, {float} C°, {float} C°")
	public void the_container_have_a_history_of_c_c_c_c(Float float1, Float float2, Float float3, Float float4) {
	   
		container.getLog().clearHistory();
		container.getLog().set(float1);
		container.getLog().set(float2);
		container.getLog().set(float3);
		container.getLog().set(float4);
		
	}

	@When("reading a request for history display")
	public void reading_a_request_for_history_display() {

		actualAnswer=container.getLog().requestHistory();

	}
	
	@Then("display the history of {float} C°, {float} C°, {float} C°, {float} C°")
	public void display_the_history_of_c_c_c_c(Float float1, Float float2, Float float3, Float float4) {
	 
		String expectedAnswer = String.valueOf(float1) + " " + String.valueOf(float2) + " " + String.valueOf(float3) + " " + String.valueOf(float4) + " ";   
		
		assertEquals(actualAnswer,expectedAnswer);
		
	}
	
	// journey management --------------------------------------------------------------------------------------------------------------------------------

	String destination;
	
	@Given("the container is in port at {string}")
	public void the_container_is_in_port_at_copenhagen(String origin) {
	    
		container.setOrigin(origin);
		
	}
	@Given("the client provides the destination {string}")
	public void the_client_provides_the_destination_hamburg(String destination) {
	    
		this.destination = destination;
		
	}
	@When("the client creates a journey for the container")
	public void the_client_creates_a_journey_for_the_container() {
		
		container.newJourney(destination);
		
	}
	@Then("check that a journey from {string} to {string} was created")
	public void check_that_a_journey_from_to_was_created(String string1, String string2) {
		
		assertEquals(container.getJourney().getOrigin(),string1);
		assertEquals(container.getJourney().getDestination(),string2);
		
		
	}
	
	@Then("return an error message saying {string}")
	public void return_an_error_message_saying(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}







	
	
	
}