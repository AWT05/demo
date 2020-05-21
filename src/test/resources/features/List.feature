@acceptance
Feature: create a list

  Background: Set the authentication and create a board
    Given The user set the authentication with correct credentials
    And the user has a board created

  @deleteBoard
  Scenario: Verify that a list can be created into a board
    When the user creates a list with the name "Test List"
    Then verifies that the list has been correctly created

  @deleteBoard
  Scenario: Verify that a list name can be edited
    Given the user creates a list
    When the user edits the list with the name "List edited"
    Then verifies that the list has been correctly edited

  @deleteBoard
  Scenario: Verify that a list can be archived
    Given the user creates a list
    When the user archives the list
    Then verify that the list has been correctly archived

  @deleteBoard
  Scenario: Verify that a list can be moved to another position
    Given the user creates a list
    When the user moves the list to another position
    Then verify that the list has been correctly moved to selected position



