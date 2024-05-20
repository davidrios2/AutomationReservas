#Author: David
  #Language: en

Feature: Find and open the official UdeA website using google search
  As a user
  I want to find and open the official UdeA website using google search
  So that I can access the information I need

  Scenario: Find and open the official UdeA website using google search
    Given I am on the google search page
    When I search for "Universidad de Antioquia"
    Then I should see the official UdeA website in the search results
    When I click on the official UdeA website link
    Then I should be redirected to the official UdeA website