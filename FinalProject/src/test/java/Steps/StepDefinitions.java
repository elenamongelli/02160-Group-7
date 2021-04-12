package Steps;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions{

	ContainerStatus container;

	@Given("a container")
	public void a_container() {

		container = new ContainerStatus();
	}

	@When("reading a temperature of {float} C°")
	public void reading_a_temperature_of_c(Float float1) {
	    // Write code here that turns the phrase above into concrete actions
	    container.readTemp(float1);
	}
	@Then("display the temperature of {float} C°")
	public void display_the_temperature_of_c(Float float1) {
	    
		assertTrue(container.currentTemp()==float1);
	}

	@When("not reading a temperature")
	public void not_reading_a_temperature() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("display a message that the sensor is not working")
	public void display_a_message_that_the_sensor_is_not_working() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("display the message until checked")
	public void display_the_message_until_checked() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}