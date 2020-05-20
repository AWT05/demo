package org.fundacion.demo;

import org.fundacion.demo.pages.HomePage;
import org.fundacion.demo.pages.LoginPage;
import org.fundacion.demo.pages.TeamPage;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fundacion.demo.DriverFactory.getChromeDriver;
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
                .continueCreation()
                .skipAddMembers();

        assertEquals(teamPage.getName(), "New Lu Team");
    }

    @Test
    public void creationTeamInLightScreemTest() {
        getChromeDriver().manage().window().setSize(new Dimension(414, 736));
        teamPage = homePage.displayCreationButtons().createTeam()
                .setValues("By Menu", "education")
                .continueCreation()
                .skipAddMembers();
        assertEquals(teamPage.getName(), "By Menu");
    }

    @AfterMethod
    public void deleteTeam() {
        homePage = teamPage.goToSettings().delete();
        getChromeDriver().quit();
    }
}
