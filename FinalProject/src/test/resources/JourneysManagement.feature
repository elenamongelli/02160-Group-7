Feature: Journeys management
 
   Background: The logistic company have a client that have a journey
    Given the client has the name "Salling"
    And their address is "Søndergade 27, 8000 Aarhus"
    And "Marianna Bedsted" as refrence person
    And "support@bilka.dk" as their contact email
    When the logistic company create "Salling" as a client

  Scenario: Journey registration
    Given the client have a container at "Copenhagen"
    And the client provides the destination "Hamburg"
    When the client creates a journey for the container
    Then check that a journey from "Copenhagen" to "Hamburg" was created

  Scenario: Failed journey registration
    If the client tries to provide the same destination as the origin

    Given the client have a container at "New York"
    And the client provides the destination "New York"
    When the client creates a journey for the container
    Then return an error of false

  Scenario: Failed journey registration
     If the client do not provide an destination

    Given the client have a container at "New York"
    And the client provides the destination " "
    When the client creates a journey for the container
    Then return an error of false

  Scenario: Failed journey registration
    If the client do not provide an origin

    Given the client have a container at " "
    And the client provides the destination "Chicago"
    When the client creates a journey for the container
    Then return an error of false

  #Container tracking
  Scenario: The logistic company wants to re-use a container for a new journey.
  	Given the client want to ship a container from "Shanghai" to "Antwerp"
    When the logistic company already have a container in "Shanghai"
    Then re-use the container for the journey


  Scenario Outline: The client wants to ship a container with <content> from <origin> to <destination>.
    When the client wants only see containers that orginated from <origin>
    Then show the client all the containers that orginated from <origin>

    Examples: 
      | origin     |
      | Copenhagen |
      | Shanghai   |
      | Antwerp    |
