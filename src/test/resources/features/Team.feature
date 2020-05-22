Feature: Create Team

  Background: Set authentication
    Given The user set the authentication with correct credentials

  Scenario: Create a Team inviting another user imperative way
    When The user goes to pull Create button
    And Fill the team name as "New test team"
    And Select "education" option in the team type drop down menu
    And Fill the description text are with "test description"
    And click on the Continue button
    And invite a member setting the email "kenshinmc23@gmail.com"
    And click on the Invite button
    Then verify the team name "New test team"
    And verify the team description "test description"
    And delete the team

  Scenario: Create a team without invite a member: declarative way
    When the user creates a team with name as "declarative test team"
    And the team type as "education"
    And the description as "declarative test description"
    Then verifies the team data and clean workspace
    #clean work space se a a un hook cuando se implemente la parte de api testing
