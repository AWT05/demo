package org.fundacion.demo.pages.login;

import org.fundacion.demo.pages.PageObject;
import org.fundacion.demo.pages.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class LoginPasswordPage extends PageObject {

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "#login-submit")
    private WebElement submitButton;

    public LoginPasswordPage(WebDriver driver) {
        super(driver);
    }

    public LoginPasswordPage setPassword(final String value) {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        password.sendKeys(value);
        return this;
    }

    public HomePage submit() {
        click(submitButton);
        return new HomePage(driver);
    }
}
