@deleteCard
Feature: Card Controller

  Background: Setup card environment
    Given "User1" is authenticated using API key and API token
    And "User2" is authenticated using API key and API token
    And "User1" has a board created
    And "User1" has a list created
    And "User1" has a card created

  @acceptance
  Scenario: Delete card created by another user
    When "User2" selects "/card/{id}" and archives it
    And "User2" archived "/card/{id}" and deletes it

    Then I validate the response has status code 200
    And I search "/card/{id}" to validate 404 code not found