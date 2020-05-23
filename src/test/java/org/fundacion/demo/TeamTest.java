package org.fundacion.demo;

import org.fundacion.demo.pages.home.HomePage;
import org.fundacion.demo.pages.login.LoginPage;
import org.fundacion.demo.pages.teams.CreateTeamOverlay;
import org.fundacion.demo.pages.teams.TeamPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.fundacion.demo.DriverFactory.getChromeDriver;
import static org.fundacion.demo.DriverFactory.lightScreen;
import static org.fundacion.demo.pages.teams.TeamTypesEnum.EDUCATION;
import static org.testng.Assert.assertEquals;

public class TeamTest {

    private HomePage homePage;
    private TeamPage teamPage;

    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(getChromeDriver());
        homePage = loginPage
                .setCredentials("carledriss3", "P@ssw0rd")
                .submit();
    }

    @Test
    public void formFillTest() {
        Map<String, String> mapfields = new HashMap<>();
        mapfields.put("name", "New Lu Team");
        mapfields.put("type", EDUCATION.toString());
        mapfields.put("description", "description");

        CreateTeamOverlay teamOverlay = homePage.quickCreateTeam();

        teamOverlay.fillForm(mapfields);
        teamPage = teamOverlay.nextSection().skipAddMembers();

        assertEquals(teamPage.getName(), "New Lu Team");
    }

    @Test
    public void creationTeamTest() {
        teamPage = homePage.quickCreateTeam()
                .setRequiredValues("New Lu Team", EDUCATION)
                .nextSection()
                .skipAddMembers();

        assertEquals(teamPage.getName(), "New Lu Team");
    }

    @Test
    public void creationTeamInLightScreenTest() {
        lightScreen();
        teamPage = homePage.displayCreationButtons().createTeam()
                .setRequiredValues("By Menu", EDUCATION)
                .setDescription("nueva descrip")
                .nextSection()
                .skipAddMembers();

        assertEquals(teamPage.getName(), "By Menu");
    }

    @AfterMethod
    public void deleteTeam() {
        homePage = teamPage.goToSettings().deleteForEver();
    }
}
