package Steps;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions{

	ContainerLog container;
	Observer ObserverA;
	String actualAnswer;

	@Given("a container")
	public void a_container() {

		container = new ContainerLog();
	}

	@When("reading a temperature of {float} C°")
	public void reading_a_temperature_of_c(Float float1) {
		// Write code here that turns the phrase above into concrete actions
		container.setTemp(float1);
	}
	@Then("display the temperature of {float} C°")
	public void display_the_temperature_of_c(Float float1) {

		assertTrue(container.getTemp()==float1);
	}

	@When("not reading a temperature")
	public void not_reading_a_temperature() {

		container.setTemp(null);

	}
	@Then("display a message that the sensor is not working")
	public void display_a_message_that_the_sensor_is_not_working() {

		ObserverA = new Observer();
		assertEquals(ObserverA.error(),"Temperature error");

	}
	@Then("display the message until checked")
	public void display_the_message_until_checked() {

		ObserverA.reset();

		assertEquals(ObserverA.error(),"No errors");

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
		
		System.out.println(this.actualAnswer);
		System.out.println(expectedAnswer);
		
		assertEquals(actualAnswer,expectedAnswer);
		
	}


}