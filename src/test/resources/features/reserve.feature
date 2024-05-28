#Author David

Feature: Fill flight booking form

  Scenario: User fills out the flight booking form
    Given the user is on the flight booking page
    When the user fills out the form with valid data
    And the user clicks on "Agregar Pasajero" button
    Then the information is shown above the authorize checkbox