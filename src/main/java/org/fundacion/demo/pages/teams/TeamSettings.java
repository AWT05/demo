package org.fundacion.demo.pages.teams;

import org.fundacion.demo.pages.home.HomePage;
import org.fundacion.demo.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamSettings extends PageObject {

    @FindBy(css = "div.window-module a.quiet-button")
    WebElement deleteTeam;

    @FindBy(css = "div.no-back input.js-confirm")
    WebElement deleteForEver;

    public TeamSettings(WebDriver driver) {
        super(driver);
    }

    public HomePage deleteForEver() {
        deleteTeam.click();
        click(deleteForEver);
        return new HomePage(driver);
    }
}
