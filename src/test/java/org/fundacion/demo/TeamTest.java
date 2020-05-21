package org.fundacion.demo;

import org.fundacion.demo.pages.home.HomePage;
import org.fundacion.demo.pages.login.LoginPage;
import org.fundacion.demo.pages.teams.TeamPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fundacion.demo.DriverFactory.getChromeDriver;
import static org.fundacion.demo.DriverFactory.lightScreen;
import static org.fundacion.demo.TeamTypes.EDUCATION;
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
    public void creationTeamTest() {
        teamPage = homePage.quickCreateTeam()
                .setValues("New Lu Team", EDUCATION.toString())
                .skipAddMembers();

        assertEquals(teamPage.getName(), "New Lu Team");
    }

    @Test
    public void creationTeamInLightScreenTest() {
        lightScreen();
        teamPage = homePage.displayCreationButtons().createTeam()
                .setValues("By Menu", EDUCATION.toString())
                .setDescription("nueva descrip")
                .skipAddMembers();

        assertEquals(teamPage.getName(), "By Menu");
    }

    @AfterMethod
    public void deleteTeam() {
        homePage = teamPage.goToSettings().deleteForEver();
    }
}