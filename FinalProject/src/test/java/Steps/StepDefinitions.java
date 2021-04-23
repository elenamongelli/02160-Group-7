package Steps;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.UUID;

import Model.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions{

	ArrayList<SensorData> actualAnswer;
	Container container;
	Facade model;
	
	@Given("logistic company {string} have a client {string}")
	public void logistic_company_have_a_client(String logisticCompanyName, String clientName) {
	   
		model = new Facade(new LogisticCompany(logisticCompanyName));
		model.createClient(clientName);
		
	}
	
	@Given("the client have a container going from from {string} to {string}")
	public void the_client_have_a_container_going_from_from_to(String origin, String destination) {
	   
		model.createContainerWithJourney(origin,destination);
		
	}
	
	
	
	@When("the container is reading a temperature of {float} C°")
	public void the_container_is_reading_a_temperature_of_c(Float temp) {
		
		container = model.getContainer(model.getContainers().size()-1);
		model.newSensorData(container,temp);
		
	}

	@Then("display the temperature of {float} C°")
	public void display_the_temperature_of_c(Float float1) {

		assertEquals(model.getLatestSensorData(container).getTemp(),float1);
	}
	 
	
	@Given("the container have a history of {float} C°, {float} C°, {float} C°, {float} C°")
	public void the_container_have_a_history_of_c_c_c_c(Float float1, Float float2, Float float3, Float float4) {
		
		container = model.getContainer(model.getContainers().size()-1);
		model.newJourney(container, "Hamburg");
		model.newSensorData(container, float1);
		model.newSensorData(container, float2);
		model.newSensorData(container, float3);
		model.newSensorData(container, float4);
	}

	@When("reading a request for history display")
	public void reading_a_request_for_history_display() {

		actualAnswer=model.getLatestLog(container).getHistory();

	}
	
	@Then("display the history of {float} C°, {float} C°, {float} C°, {float} C°")
	public void display_the_history_of_c_c_c_c(Float float1, Float float2, Float float3, Float float4) {
		
		Log log = new Log(new ArrayList<SensorData>());
		log.addSensorData(new SensorData(float1));
		log.addSensorData(new SensorData(float2));
		log.addSensorData(new SensorData(float3));
		log.addSensorData(new SensorData(float4));
		
		ArrayList<SensorData> expectedAnswer = log.getHistory();
		
		for(int i=0; i<3; i++) {
		assertEquals(expectedAnswer.get(i).toString(),actualAnswer.get(i).toString());
		}
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