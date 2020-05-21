@deleteCard
Feature: Card Controller

  Background: Setup card environment
    Given "User1" is authenticated using API key and API token
    And "User2" is authenticated using API key and API token
    And "User1" has a board created
    And "User1" has a list created
    And "User2" has a list created
    And "User1" has a card created

  @acceptance
  Scenario: Move card to another list
    When "User2" selects card:"/card/{id}" and moves it to list:"/list/{id}
    Then I validate the response has status code 200
    And I validate "/card/{id}" is on list "/list/{id}
    And clean workspace