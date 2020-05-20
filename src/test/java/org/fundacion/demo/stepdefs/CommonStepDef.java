package org.fundacion.demo.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managepage.Home;
import managepage.Login;

public class CommonStepDef {

    Login loginPage = new Login();
    Home homePage = new Home();

    @Given("The user set the authentication with correct credentials")
    public void userSetTheAuthentication() {
        loginPage.login();
    }

    @When("The user goes to pull Create button")
    public void theUserGoesToPullButton() {
        homePage.selectCreateTeam();
    }


}
