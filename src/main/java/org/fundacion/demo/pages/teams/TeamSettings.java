package org.fundacion.demo.pages.teams;

import org.fundacion.demo.pages.home.HomePage;
import org.fundacion.demo.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class TeamSettings extends PageObject {

    public static final String DELETE_BUTTON = "a.quiet-button";
    public static final String DELETE_CONFIRM = "input.js-confirm";
    @FindBy(css = DELETE_BUTTON)
    private WebElement deleteTeam;

    @FindBy(css = DELETE_CONFIRM)
    private WebElement deleteForEver;

    public TeamSettings(final WebDriver driver) {
        super(driver);
    }

    public HomePage deleteForEver() {
        deleteTeam.click();
        click(deleteForEver);
        return new HomePage(driver);
    }
}
