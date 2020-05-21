@deleteCard
Feature: Card Controller

  Background: Setup card environment
    Given "User1" is authenticated using API key and API token
    And "User2" is authenticated using API key and API token
    And "User1" has a board created
    And "User1" has a list created
    And "User1" has a card created

  @acceptance
  Scenario: Update the name of a card created by another user
    When "User2" edits created card: "/card/{id}" with the following parameter
      | name | Card updated by User 2 |

    Then I validate the response has status code 200
    And I validate "/card/{id}" has the following name " Card updated by User 2
    And clean workspace