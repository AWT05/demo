@deleteCard
Feature: Card Controller

  Background: Setup card environment
    Given "User1" is authenticated using API key and API token
    And "User1" has a board created
    And "User1" has a list created

  @acceptance
  Scenario: Create a card
    When I send a POST request to "/card/{id}" with the following parameters
      | name | Card created by User 1 |
    Then I validate the response has status code 200
    And I validate the response body should match with "boards/boardSchema.json" JSON schema
    And I validate the response contains the following data
      | name | Card created by User 1 |

