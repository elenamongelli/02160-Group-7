Feature: Monitor internal status of container

	#ask Andrea

  Scenario: Successfull reading of temperature
    Given a container has a temperature sensor true
    And the temperature is within -80 C° to 40 C°
    When reading a temperature of 25 C°
    Then display the temperature of 25 C°

  Scenario: Unsuccessfull reading of temperature
    Given a container having a temperature sensor
    And the temperature is not within -80 C° to 40 C°
    When reading the temperature
    Then display a message that the sensor is not working
    And display the message until checked

  Scenario: A temperature measurement is not with the specified range for the container 
    Given a container has a temperature sensor
    And a range is specified
    And the temperature is outside the range  
    When reading the temperature
    Then display a message that the temperature is incorrect