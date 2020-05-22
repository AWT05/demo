package org.fundacion.demo.pages.home;

import org.fundacion.demo.pages.teams.CreateTeamOverlay;
import org.fundacion.demo.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class HomePage extends PageObject {
    private static final String CREATE_TEAM_BUTTON = "button[data-test-id=home-navigation-create-team-button]";
    private static final String HEADER_CREATE_MENU_BUTTON = "button[data-test-id=header-create-menu-button]";
    private static final String HEADER_CREATE_TEAM_BUTTON = "button[data-test-id=header-create-team-button]";

    @FindBy(css = CREATE_TEAM_BUTTON)
    private WebElement homeNavCreateTeamButton;

    @FindBy(css = HEADER_CREATE_MENU_BUTTON)
    private WebElement headerMenuButton;

    @FindBy(css = HEADER_CREATE_TEAM_BUTTON)
    private WebElement headerMenuCreateTeamButton;

    public HomePage(final WebDriver driver) {
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
