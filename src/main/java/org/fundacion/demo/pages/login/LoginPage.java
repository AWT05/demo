package org.fundacion.demo.pages.login;

import org.fundacion.demo.pages.PageObject;
import org.fundacion.demo.pages.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class LoginPage extends PageObject {

    private static final String URL = "https://trello.com/login";
    private static final String USER_ID = "#user";
    private static final String PASSWORD_ID = "#password";
    private static final String ACCOUNT_BUTTON = "input.account-button";

    @FindBy(css = USER_ID)
    private WebElement username;

    @FindBy(css = PASSWORD_ID)
    private WebElement password;

    @FindBy(css = ACCOUNT_BUTTON)
    private WebElement button;

    @FindBy(css = "input#login")
    private WebElement initWithAtlassian;

    public LoginPage(final WebDriver driver) {
        super(driver);
        driver.get(URL);
    }

    /**
     * Sets credentials values to the form.
     *
     * @param username account username.
     * @param password security password.
     * @return this Login page.
     */
    public LoginPage setCredentials(final String username, final String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        return this;
    }

    /**
     * Submits the form.
     *
     * @return a new Home page.
     */
    public HomePage submit() {
        click(button);
        return new HomePage(driver);
    }

    /**
     * Sets Atlassian credential.
     *
     * @param email account username.
     * @return a new LoginPassword page.
     */
    public LoginPasswordPage setEmail(final String email) {
        this.username.sendKeys(email);
        click(initWithAtlassian);
        return new LoginPasswordPage(driver);
    }
}
