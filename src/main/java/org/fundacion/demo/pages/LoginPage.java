package org.fundacion.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    private final static String URL = "https://trello.com/login";

    @FindBy(css = "#user")
    WebElement username;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(css = "input.account-button")
    WebElement button;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage setCredentials(String username, String password) {
        driver.get(URL);

        this.username.sendKeys(username);
        this.password.sendKeys(password);

        return this;
    }

    public HomePage submit() {
        button.click();
        return new HomePage(driver);
    }
}
