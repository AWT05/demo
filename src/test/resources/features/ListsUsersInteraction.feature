Feature: Users interaction lists

  Background: user A set the environment
    Given the "user A" set his credentials
    And the user has a board created
    And the user has a list created

    Scenario: user B modifies the list created by the user A
      Given the "user B" set his credentials
      And the user edits the list with the name "List edited by user B"
      Then verifies that the list has been correctly edited
