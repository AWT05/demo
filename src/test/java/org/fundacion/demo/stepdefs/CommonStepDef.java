package org.fundacion.demo.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managepage.Home;
import managepage.Login;

public class CommonStepDef {

    private Login loginPage;
    private Home homePage;

    public CommonStepDef() {
        loginPage = new Login();
        homePage = new Home();
    }

    @Given("The user set the authentication with correct credentials")
    public void userSetTheAuthentication() {
        loginPage.login();
    }

    @When("The user goes to pull Create button")
    public void theUserGoesToPullButton() {
        homePage.selectCreateTeam();
    }


}
