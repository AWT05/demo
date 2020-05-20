package org.fundacion.demo;

import org.fundacion.demo.pages.HomePage;
import org.fundacion.demo.pages.LoginPage;
import org.fundacion.demo.pages.TeamPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fundacion.demo.DriverFactory.getChromeDriver;
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
                .setValues("New Lu Team", "education")
                .continueCreation()
                .skipAddMembers();

        assertEquals(teamPage.getName(), "New Lu Team");
    }

    @AfterMethod
    public void deleteTeam() {
        homePage = teamPage.goToSettings().delete();
        getChromeDriver().quit();
    }
}
