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
