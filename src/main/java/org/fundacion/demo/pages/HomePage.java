package org.fundacion.demo.pages;

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
        homeNavCreateTeamButton.click();
        return new CreateTeamOverlay(driver);
    }
}
