package org.fundacion.demo.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managepage.Home;
import managepage.team.CreateTeamForm;
import managepage.team.TeamBoards;
import managepage.team.TeamSettings;

import static org.testng.Assert.assertEquals;

public class CommonDeclarativeSteps {

    private Home homepage;
    private CreateTeamForm teamForm;
    private TeamBoards teamBoards;
    private TeamSettings teamSettings;

    private String teamName;
    private String description;

    public CommonDeclarativeSteps() {
        homepage = new Home();
        teamForm = new CreateTeamForm();
        teamBoards = new TeamBoards();
        teamSettings = new TeamSettings();
    }

    @When("the user creates a team with name as {string}")
    public void theUserCreatesATeamWithNameAs(String teamName) {
        this.teamName = teamName;
        homepage.selectCreateTeam();
        teamForm.fillTeamName(teamName);
    }

    @And("the team type as {string}")
    public void theTeamTypeAs(String typeTeam) {
        teamForm.selectTeamTypeMenu(typeTeam);
    }

    @And("the description as {string}")
    public void theDescriptionAs(String description) {
        this.description = description;
        teamForm.fillTextArea(description);
        teamForm.continueButtonAction();
        teamForm.inviteMembersLatterButton();
    }

    @Then("verifies the team data and clean workspace")
    public void theUserVerifiesTheTeamData() {
        assertEquals(teamBoards.getTeamName(), teamName);
        assertEquals(teamBoards.getDescription(), description);
        teamBoards.selectTeamSettings();
        teamSettings.selectDeleteTeam();
        teamSettings.confirmDeleteTeam();
    }
}
