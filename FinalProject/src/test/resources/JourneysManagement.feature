Feature: Journeys management

  Background: 
    Given logistic company "Mærsk" have a client "Netto"
    And the client "Netto" have a container

  Scenario: Journey registration
    Given the container is in port at "Copenhagen"
    And the client provides the destination "Hamburg"
    When the client creates a journey for the container
    Then check that a journey from "Copenhagen" to "Hamburg" was created

  Scenario: Failed journey registration
    If the client tries to provide the same destination as the origin

    Given the container is in port at "Copenhagen"
    And the client provides the destination "Copenhagen"
    When the client creates a journey for the container
    Then return an error message saying "Same destination as origin"

  Scenario: Failed journey registration
     If the client do not provide an destination

    When the client creates a journey for the container
    And the container is in port at "Rotterdam"
    But the client provides the destination " "
    Then return an error message saying "No destination"

  Scenario: Failed journey registration
    If the client do not provide an origin

    When the client creates a journey for the container
    And the container is in port at " "
    But the client provides the destination "Los Angeles"
    Then return an error message saying "No origin"

  #Container tracking
  Scenario Outline: The client wants to filter for origin
    When the client wants only see containers that orginated from <origin>
    Then show the client all the containers that orginated from <origin>

    Examples: 
      | origin     |
      | Copenhagen |
      | Shanghai   |
      | Antwerp    |

  Scenario Outline: The client wants to filter for destination
    When the client wants only see containers with the destination of <destination>
    Then show the client all the containers with the destination of <destination>

    Examples: 
      | destination |
      | Hamburg     |
      | Rotterdam   |
      | Los Angeles |
