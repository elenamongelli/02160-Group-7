Feature: Monitor internal status of container

	#ask Andrea

  Scenario: Successfull reading of temperature
    Given a container
    When reading a temperature of 25 C°
    Then display the temperature of 25 C°

  Scenario: Unsuccessfull reading of temperature
    Given a container
    When not reading a temperature
    Then display a message that the sensor is not working
    And display the message until checked
