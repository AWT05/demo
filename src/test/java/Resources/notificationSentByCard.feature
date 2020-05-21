@deleteCard
Feature: Card Controller

  Background: Setup card environment
    Given "User1" is authenticated using API key and API token
    And "User2" is authenticated using API key and API token
    And "User1" has a board created
    And "User1" has a list created
    And "User1" has a card created
    And "User1" is assigned to a card

  @acceptance
  Scenario: Card sends notification when due date is over
    When  Card: "/card/{id}" has due date over
    Then I validate "/card/{id}" notification is on received notifications on "User1"
    And clean workspace
