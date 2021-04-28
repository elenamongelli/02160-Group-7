package Steps;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		String actualName = model.returnClientByName(clientName).getName();
		assertEquals(actualName,clientName);
		String actualAddress = model.returnClientByName(clientName).getAddress();
		assertEquals(actualAddress,address);
		String actualRefrencePerson = model.returnClientByName(clientName).getReferencePerson();
		assertEquals(actualRefrencePerson,refrencePerson);
		String actualEmail= model.returnClientByName(clientName).getEmail();
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
		assertEquals(this.newName,model.returnClientByName(newName).getName());
		assertEquals(this.address,model.returnClientByName(newName).getAddress());
		assertEquals(this.refrencePerson,model.returnClientByName(newName).getReferencePerson());
		assertEquals(this.email,model.returnClientByName(newName).getEmail());
	}

	String originCheck;
	String destinationCheck;
	@Given("they have the following journies")
	public void they_have_the_following_journies(io.cucumber.datatable.DataTable dataTable) {
		originCheck = dataTable.cell(1, 0);
		destinationCheck = dataTable.cell(3, 1);
		model.newJourney(this.clientName, dataTable.cell(1, 0), dataTable.cell(1, 1), null);
		model.newJourney(this.clientName, dataTable.cell(2, 0), dataTable.cell(2, 1), null);
		model.newJourney(this.clientName, dataTable.cell(3, 0), dataTable.cell(3, 1), null);
	}

	ArrayList<Container> ContainersByName;
	@When("they search for their containers by name")
	public void they_search_for_their_containers_by_name() {
		ContainersByName = model.getClientContainersByName(this.clientName);
	}

	ArrayList<Container> ContainersByEmail;
	@When("they also try by using their email")
	public void they_also_try_by_using_their_email() {
		ContainersByEmail = model.getClientContainersByEmail(this.email);
	}
	@Then("validata that their containers are provided")
	public void validata_that_their_containers_are_provided() {
		assertEquals(ContainersByName,ContainersByEmail);
		assertEquals(ContainersByName.get(0).getLatestJourney().getOrigin(),originCheck);
		assertEquals(ContainersByName.get(2).getLatestJourney().getDestination(),destinationCheck);
	}

	String client2;
	@Given("the logistic company have two clients")
	public void the_logistic_company_have_two_clients(io.cucumber.datatable.DataTable dataTable) {
		model = new Facade();
		model.createClient(dataTable.cell(0, 0), dataTable.cell(1, 0), dataTable.cell(2, 0), dataTable.cell(3, 0));
		model.createClient(dataTable.cell(0, 1), dataTable.cell(1, 1), dataTable.cell(2, 1), dataTable.cell(3, 1));
		client2=dataTable.cell(0, 1);
	}
	@When("the logistic client deletes the first client")
	public void the_logistic_client_deletes_the_first_client() {
		model.deleteClient(0);
	}

	@Then("the first client should be deleted")
	public void the_first_client_should_be_deleted() {
		assertEquals(model.getClient(0).getName(),client2);
	}

	String client1;
	ArrayList<String> expectedData = new ArrayList<String>();
	@Given("the first client have three registered containers")
	public void the_first_client_have_three_registered_containers(io.cucumber.datatable.DataTable dataTable) {
		client1 = model.getClient(0).getName();
		model.newJourney(client1, dataTable.cell(1, 0), dataTable.cell(1, 1), dataTable.cell(1, 2));
		model.newJourney(client1,dataTable.cell(2, 0), dataTable.cell(2, 1), dataTable.cell(2, 2));
		model.newJourney(client1, dataTable.cell(3, 0), dataTable.cell(3, 1), dataTable.cell(3, 2));
		expectedData.add(dataTable.cell(1, 0));
		expectedData.add(dataTable.cell(1, 1));
		expectedData.add(dataTable.cell(1, 2));
	}
	@When("the client who owns the containers lets the other client view one container")
	public void the_client_who_owns_the_containers_lets_the_other_client_view_one_container() {
		Container container = model.getClientContainersByName(client1).get(0);
		String owner = client1;
		String viewer = model.getClient(1).getName();
		client2 = viewer;
		model.addViewer(container, owner, viewer);
	}
	@Then("the second client should see that container on their list of containers")
	public void the_second_client_should_see_that_container_on_their_list_of_containers() {
		assertEquals(expectedData.get(0),model.getViewerContainers(client2).get(0).getOrigin());
		assertEquals(expectedData.get(1),model.getViewerContainers(client2).get(0).getLatestJourney().getDestination());
		assertEquals(expectedData.get(2),model.getViewerContainers(client2).get(0).getLatestJourney().getContent());
	}
	@Then("the first client should see the second client listed as a viewer to the container which has been shared")
	public void the_first_client_should_see_the_second_client_listed_as_a_viewer_to_the_container_which_has_been_shared() {

	}

	// container management --------------------------------------------------------------------------

	ArrayList<SensorData> actualAnswer;
	Container container;

	@Given("the client have a container going from from {string} to {string}")
	public void the_client_have_a_container_going_from_from_to(String origin, String destination) {
		model.newJourney(clientName, origin, destination, null);
	}

	@When("the container is reading a temperature of {float} C°")
	public void the_container_is_reading_a_temperature_of_c(Float temp) {
		container = model.getContainer(model.getAllContainers().size()-1);
		model.newSensorDataTemp(container, temp);
	}

	@Then("display the temperature of {float} C°")
	public void display_the_temperature_of_c(Float float1) {
		assertEquals(model.getLatestSensorData(container).getTemp(),float1);
	}


	@Given("the container have a history of {float} C°, {float} C°, {float} C°, {float} C°")
	public void the_container_have_a_history_of_c_c_c_c(Float float1, Float float2, Float float3, Float float4) {
		model.newJourney(clientName, "London", "Hamburg", null);
		container = model.getContainer(model.getAllContainers().size()-1);
		model.newSensorDataTemp(container, float1);
		model.newSensorDataTemp(container, float2);
		model.newSensorDataTemp(container, float3);
		model.newSensorDataTemp(container, float4);
	}

	@When("reading a request for history display")
	public void reading_a_request_for_history_display() {
		actualAnswer=model.getLatestLog(container).getHistory();
	}

	@Then("display the history of {float} C°, {float} C°, {float} C°, {float} C°")
	public void display_the_history_of_c_c_c_c(Float float1, Float float2, Float float3, Float float4) {
		Log log = new Log(new ArrayList<SensorData>());
		log.addSensorData(new SensorData(float1, null, null, null));
		log.addSensorData(new SensorData(float2, null, null, null));
		log.addSensorData(new SensorData(float3, null, null, null));
		log.addSensorData(new SensorData(float4, null, null, null));
		ArrayList<SensorData> expectedAnswer = log.getHistory();

		for(int i=0; i<3; i++) {
			assertEquals(expectedAnswer.get(i).getTemp().toString(),actualAnswer.get(i).getTemp().toString());
		}
	}

	List<String> expectedAnswer;
	@Given("a container have a history")
	public void a_container_have_a_history(io.cucumber.datatable.DataTable dataTable) {
		container = model.getContainer(0);
		expectedAnswer = dataTable.asList();
		model.newSensorDataAll(container,Float.parseFloat(expectedAnswer.get(3)),expectedAnswer.get(4),expectedAnswer.get(5));
		model.newSensorDataAll(container,null,expectedAnswer.get(7),expectedAnswer.get(8));
		model.newSensorDataAll(container,Float.parseFloat(expectedAnswer.get(9)),expectedAnswer.get(10),expectedAnswer.get(11));
		model.newSensorDataAll(container,Float.parseFloat(expectedAnswer.get(12)),expectedAnswer.get(13),expectedAnswer.get(14));
	}


	@Then("validate that the history stored is correct")
	public void validate_that_the_history_stored_is_correct() {
		List<String> actualAnswer = new ArrayList<String>();
		actualAnswer.add(model.getContainer(0).getLatestJourney().getLog().getHistory().get(0).getTemp().toString());
		actualAnswer.add(model.getContainer(0).getLatestJourney().getLog().getHistory().get(0).getPosition());
		actualAnswer.add(model.getContainer(0).getLatestJourney().getLog().getHistory().get(0).getHumidity());

		actualAnswer.add(null);
		actualAnswer.add(model.getContainer(0).getLatestJourney().getLog().getHistory().get(1).getPosition());
		actualAnswer.add(model.getContainer(0).getLatestJourney().getLog().getHistory().get(1).getHumidity());

		actualAnswer.add(model.getContainer(0).getLatestJourney().getLog().getHistory().get(2).getTemp().toString());
		actualAnswer.add(null);
		actualAnswer.add(model.getContainer(0).getLatestJourney().getLog().getHistory().get(2).getHumidity());

		actualAnswer.add(model.getContainer(0).getLatestJourney().getLog().getHistory().get(3).getTemp().toString());
		actualAnswer.add(model.getContainer(0).getLatestJourney().getLog().getHistory().get(3).getPosition());
		actualAnswer.add(null);

		for(int i = 0; i<actualAnswer.size(); i++) {
			assertEquals(expectedAnswer.get(i+3),actualAnswer.get(i));
		}

	}


	@Given("the container adds sensordata")
	public void the_container_adds_sensordata(io.cucumber.datatable.DataTable dataTable) {
		container = model.getContainer(0);
		model.newSensorDataAll(container, Float.parseFloat(dataTable.cell(1, 0)), dataTable.cell(1, 1), dataTable.cell(1, 2));
	}

	String actualAnswerTimestamp;
	@When("the sensordata is added note the time")
	public void the_sensordata_is_added_note_the_time() {
		actualAnswerTimestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}

	@Then("check that the sensordata have the corret timestamp")
	public void check_that_the_sensordata_have_the_corret_timestamp() {
		assertEquals(actualAnswerTimestamp,model.getLatestSensorData(container).getTimeStamp());
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

		error = model.newJourney(clientName, origin, destination, null);
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
		error = model.newJourney(clientName, "Stockholm", origin, null);	
		if(error) container = model.getContainer(model.getAllContainers().size()-1);
		model.endJourney(container);
		model.newJourney(clientName, origin, destination, null);
	}

	@Then("re-use the container for the journey")
	public void re_use_the_container_for_the_journey() {
		assertTrue(model.getAllContainers().size()==1);
	}


}