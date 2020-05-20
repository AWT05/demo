Feature: Create Team

  Background: Set authentication
    Given The user set the authentication with correct credentials

  Scenario: Create a Team
    When The user goes to pull Create button
    And Fill the team name as "New test team"
    And Select "Education" option in the team type drop down menu
    And Fill the description text are with "test description"
    And click on the Continue button
    And invite a member setting the email "kenshinmc23@gmail.com"
    And click on the Invite button
    Then verify the team name "New test team"

