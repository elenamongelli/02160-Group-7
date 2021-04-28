Feature: Client management

  Scenario: The logistic company wants to create a new client
    Given the client has the name "Salling"
    And their address is "Søndergade 27, 8000 Aarhus"
    And "Marianna Bedsted" as refrence person
    And "kontakt@salling.dk" as their contact email
    When the logistic company create "Salling" as a client
    Then validate that all the client information is correct

  Scenario: A client "Salling" want to update their information
    Given the client "Salling" have the information
      | "Søndergade 27, 8000 Aarhus" |
      | "Marianna Bedsted"           |
      | "kontakt@salling.dk"         |
    And their new name is "Netto"
    And their new address is "Kollegiebakken 7, 2800 Kongens Lyngby"
    And their new refrence person is "Anders Bjarklev"
    And their new email is "dtu@netto.dk"
    When updating their information
    Then validate that their information is updated

  Scenario: A client "Salling" want to look at their containers
    Given the client "Salling" have the information
      | "Søndergade 27, 8000 Aarhus" |
      | "Marianna Bedsted"           |
      | "kontakt@salling.dk"         |
    And they have the following journies
      | "Origin"    | "Destination" |
      | "Amsterdam" | "Copenhagen"  |
      | "Barcelona" | "Aarhus"      |
      | "London"    | "Esbjerg"     |
    When they search for their containers by name
    And they also try by using their email
    Then validata that their containers are provided

  Scenario: The logistic company wants to delete a client.
    Given the logistic company have two clients
      | "Salling"                    | "Coop"                             |
      | "Søndergade 27, 8000 Aarhus" | "Roskildevej 65, 2620 Albertslund" |
      | "Marianna Bedsted"           | "Allan Nørholm"                    |
      | "kontakt@salling.dk"         | "kontakt@coop.dk"                  |
    When the logistic client deletes the first client
    Then the first client should be deleted

  Scenario: A client want to give another client acces to view one or multiple choosen container(s)
    Given the logistic company have two clients
      | "Salling"                    | "Coop"                             |
      | "Søndergade 27, 8000 Aarhus" | "Roskildevej 65, 2620 Albertslund" |
      | "Marianna Bedsted"           | "Allan Nørholm"                    |
      | "kontakt@salling.dk"         | "kontakt@coop.dk"                  |
    And the first client have three registered containers
      | "Origin"     | "Destination" | "Content"     |
      | "Copenhagen" | "Paris"       | "fish"        |
      | "Oslo"       | "Aalborg"     | "Red Aalborg" |
      | "Aarhus"     | "Roskilde"    | "jyder"       |
    When the client who owns the containers lets the other client view one container
    Then the second client should see that container on their list of containers
    And the first client should see the second client listed as a viewer to the container which has been shared
