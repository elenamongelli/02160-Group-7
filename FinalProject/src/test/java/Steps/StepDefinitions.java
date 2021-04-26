package Steps;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import Model.*;
import io.cucumber.java.en.*;

public class StepDefinitions{
	
	// client management ---------------------------------------------------------------------------------

	Facade model;
	
	String clientName;
	String address;
	String refrencePerson;
	String email;
	
	@Given("the client has the name {string}")
	public void the_client_has_the_name(String clientName) {
	    this.clientName = clientName;
	}
	@Given("their address is {string}")
	public void their_address_is(String address) {
	    this.address = address;
	}
	@Given("{string} as refrence person")
	public void as_refrence_person(String refrencePerson) {
	    this.refrencePerson = refrencePerson;
	}
	@Given("{string} as their contact email")
	public void as_their_contact_email(String email) {
	    this.email = email;
	}
	@When("the logistic company create {string} as a client")
	public void the_logistic_company_create_as_a_client(String string) {
		model = new Facade();
		model.createClient(clientName, address, refrencePerson, email);
	}
	@Then("validate that all the client information is correct")
	public void validate_that_all_the_client_information_is_correct() {
		String actualName = model.returnClient(clientName).getName();
		assertEquals(actualName,clientName);
		String actualAddress = model.returnClient(clientName).getAddress();
		assertEquals(actualAddress,address);
		String actualRefrencePerson = model.returnClient(clientName).getReferencePerson();
		assertEquals(actualRefrencePerson,refrencePerson);
		String actualEmail= model.returnClient(clientName).getEmail();
		assertEquals(actualEmail,email);
	}
	
	@Given("the client {string} have the information")
	public void the_client_have_the_information(String clientName, io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> info = dataTable.asLists(String.class);
		
		this.clientName = clientName;
		address = info.get(0).toString();
		refrencePerson = info.get(1).toString();
		email = info.get(2).toString();
		
		model = new Facade();
		model.createClient(clientName, address, refrencePerson, email);
	}
	
	String newName;
	@And("their new name is {string}")
	public void their_new_name_is(String newName) {
	    this.newName = newName;
	}
	
	@And("their new address is {string}")
	public void their_new_address_is(String address) {
	    this.address = address;
	}

	@Given("their new refrence person is {string}")
	public void their_new_refrence_person_is(String refrencePerson) {
	    this.refrencePerson = refrencePerson;
	}

	@Given("their new email is {string}")
	public void their_new_email_is(String email) {
	    this.email = email;
	}

	@When("updating their information")
	public void updating_their_information() {
		model.updateClientName(clientName, newName);
		model.updateClientAddress(newName, address);
		model.updateClientRefrencePerson(newName, refrencePerson);
		model.updateClientEmail(newName, email);
	}

	@Then("validate that their information is updated")
	public void validate_that_their_information_is_updated() {
		assertEquals(this.newName,model.returnClient(newName).getName());
		assertEquals(this.address,model.returnClient(newName).getAddress());
		assertEquals(this.refrencePerson,model.returnClient(newName).getReferencePerson());
		assertEquals(this.email,model.returnClient(newName).getEmail());
	}

	// container management --------------------------------------------------------------------------
	
	ArrayList<SensorData> actualAnswer;
	Container container;
	
	@Given("the client have a container going from from {string} to {string}")
	public void the_client_have_a_container_going_from_from_to(String origin, String destination) {
		model.newJourney(clientName, origin, destination);
	}

	@When("the container is reading a temperature of {float} C°")
	public void the_container_is_reading_a_temperature_of_c(Float temp) {
		container = model.getContainer(model.getAllContainers().size()-1);
		model.newSensorData(container, temp);
	}

	@Then("display the temperature of {float} C°")
	public void display_the_temperature_of_c(Float float1) {
		assertEquals(model.getLatestSensorData(container).getTemp(),float1);
	}


	@Given("the container have a history of {float} C°, {float} C°, {float} C°, {float} C°")
	public void the_container_have_a_history_of_c_c_c_c(Float float1, Float float2, Float float3, Float float4) {
		model.newJourney(clientName, "London", "Hamburg");
		container = model.getContainer(model.getAllContainers().size()-1);
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
		log.addSensorData(new SensorData(float1, null, null));
		log.addSensorData(new SensorData(float2, null, null));
		log.addSensorData(new SensorData(float3, null, null));
		log.addSensorData(new SensorData(float4, null, null));
		ArrayList<SensorData> expectedAnswer = log.getHistory();

		for(int i=0; i<3; i++) {
			assertEquals(expectedAnswer.get(i).toString(),actualAnswer.get(i).toString());
		}
	}

	// journey management --------------------------------------------------------------------------------------------
	String origin;
	String destination;
	Boolean error;

	@Given("the client have a container at {string}")
	public void the_client_have_a_container_at(String origin) {

		this.origin = origin;

	}
	
	@Given("the client provides the destination {string}")
	public void the_client_provides_the_destination(String destination) {

		this.destination = destination;

	}
	
	@When("the client creates a journey for the container")
	public void the_client_creates_a_journey_for_the_container() {

		error = model.newJourney(clientName, origin, destination);
		if(error) container = model.getContainer(model.getAllContainers().size()-1);
	}
	
	@Then("check that a journey from {string} to {string} was created")
	public void check_that_a_journey_from_to_was_created(String origin, String destination) {

		String actualOrigin= model.getLatestJourney(container).getOrigin();
		String actualDestination = model.getLatestJourney(container).getDestination();

		assertEquals(actualOrigin,origin);
		assertEquals(actualDestination,destination);
	}

	@Then("return an error of false")
	public void return_an_error_of_false() {
		assertEquals(this.error,false);
	}

	@Given("the client want to ship a container from {string} to {string}")
	public void the_client_want_to_ship_a_container_from_to(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}
	
	@When("the logistic company already have a container in {string}")
	public void the_logistic_company_already_have_a_container_in(String origin) {
		error = model.newJourney(clientName, "Stockholm", origin);	
		if(error) container = model.getContainer(model.getAllContainers().size()-1);
		model.endJourney(container);
		model.newJourney(clientName, origin, destination);
	}
	
	@Then("re-use the container for the journey")
	public void re_use_the_container_for_the_journey() {
		assertTrue(model.getAllContainers().size()==1);
	}

}