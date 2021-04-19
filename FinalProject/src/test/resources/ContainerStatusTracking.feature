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

  Scenario: Display history of internal measurments
    Given a container with a history of 25 C°, 10 C°, 2 C°, 30 C°
    When reading a request for history display
    Then display the history of 25 C°, 10 C°, 2 C°, 30 C°

