package org.fundacion.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamSettings extends PageObject {

    @FindBy(css = "div.window-module a.quiet-button")
    WebElement deleteTeam;

    @FindBy(css = "input.js-confirm[type=submit]")
    WebElement deleteForEver;

    public TeamSettings(WebDriver driver) {
        super(driver);
    }

    public HomePage delete() {
        deleteTeam.click();
        deleteForEver.click();
        return new HomePage(driver);
    }
}
