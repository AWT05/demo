package org.fundacion.demo.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managepage.team.CreateTeamForm;
import managepage.team.TeamBoards;
import managepage.team.TeamSettings;

import static org.testng.Assert.assertEquals;

public class TeamStepDef {

    private CreateTeamForm teamForm;
    private TeamBoards teamBoards;
    private TeamSettings teamSettings;

    public TeamStepDef(){
      teamForm = new CreateTeamForm();
      teamBoards = new TeamBoards();
      teamSettings = new TeamSettings();
    }

    @When("Fill the team name as {string}")
    public void fillTheTeamNameAs(String teamName) {
        teamForm.fillTeamName(teamName);
    }

    @When("Select {string} option in the team type drop down menu")
    public void selectOptionInTheDropDownMenu(String teamType) {
        teamForm.selectTeamTypeMenu(teamType);
    }

    @When("Fill the description text are with {string}")
    public void fillTheDescriptionTextAreWith(String description) {
        teamForm.fillTextArea(description);
    }

    @When("click on the Continue button")
    public void clickOnTheContinueButton() {
        teamForm.continueButtonAction();
    }

    @When("invite a member setting the email {string}")
    public void inviteAMemberSettingTheEmail(String email) {
        teamForm.fillEmailTexBox(email);
    }

    @When("click on the Invite button")
    public void clickOnTheInviteButton() {
        teamForm.inviteButtonAction();
    }

    @Then("verify the team name {string}")
    public void verifyTheTeamName(String expectedName) {
        assertEquals(teamBoards.getTeamName(), expectedName);
    }

    @Then("verify the team description {string}")
    public void verifyTheTeamDescription(String expectedDescription) {
        assertEquals(teamBoards.getDescription(),expectedDescription);
    }

    @When("delete the team")
    public void deleteTheTeam() {
        teamBoards.selectTeamSettings();
        teamSettings.selectDeleteTeam();
        teamSettings.confirmDeleteTeam();
    }
}
