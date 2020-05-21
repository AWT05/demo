package org.fundacion.demo.pages.home;

import org.fundacion.demo.pages.teams.CreateTeamOverlay;
import org.fundacion.demo.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {
    @FindBy(css = "button[data-test-id=home-navigation-create-team-button]")
    private WebElement homeNavCreateTeamButton;

    @FindBy(css = "button[data-test-id=header-create-menu-button]")
    private WebElement headerMenuButton;

    @FindBy(css = "button[data-test-id=header-create-team-button]")
    private WebElement headerMenuCreateTeamButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CreateTeamOverlay quickCreateTeam() {
        click(homeNavCreateTeamButton);
        return new CreateTeamOverlay(driver);
    }

    public HomePage displayCreationButtons() {
        click(headerMenuButton);
        return this;
    }

    public CreateTeamOverlay createTeam() {
        click(headerMenuCreateTeamButton);
        return new CreateTeamOverlay(driver);
    }
}
