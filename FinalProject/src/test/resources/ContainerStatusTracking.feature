Feature: Monitor internal status of container

  Background: The logistic company have a client that have a journey
    Given the client has the name "Salling"
    And their address is "Søndergade 27, 8000 Aarhus"
    And "Marianna Bedsted" as refrence person
    And "support@bilka.dk" as their contact email
    When the logistic company create "Salling" as a client
    And the client have a container going from from "Copenhagen" to "New York"

  Scenario Outline: Successfull reading of temperature
    When the container is reading a temperature of <temp> C°
    Then display the temperature of <temp> C°

    Examples: 
      | temp |
      |   25 |
      |   -1 |
      | 10.5 |

  Scenario Outline: Add and dispay temperature hsitory
    Given the container have a history of <temp1> C°, <temp2> C°, <temp3> C°, <temp4> C°
    When reading a request for history display
    Then display the history of <temp1> C°, <temp2> C°, <temp3> C°, <temp4> C°

    Examples: 
      | temp1 | temp2 | temp3 | temp4 |
      |    25 |    10 |     2 |    30 |
      |    -1 |   -10 |    50 |    23 |
      |   1.5 |  26.3 | 23    |     4 |

  Scenario Outline: Add and display diffrent sensordata
    Given the container have a history of
      | Temperature | Position          | Humidity |
      |          25 | "55.2125;10.1022" | "10%"    |
      |             | "55.3;11.521"     | "15%"    |
      |          20 |                   | "12%"    |
      |          20 | "55.652;9,1253"   |          |
