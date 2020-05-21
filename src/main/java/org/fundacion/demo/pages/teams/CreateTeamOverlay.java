package org.fundacion.demo.pages.teams;

import org.fundacion.demo.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateTeamOverlay extends PageObject {

    @FindBy(css = "a[data-test-id=show-later-button]")
    private WebElement skipMembersButton;

    @FindBy(css = "footer button[data-test-id=header-create-team-submit-button]")
    private WebElement continueCreation;

    @FindBy(css = "input[data-test-id=header-create-team-name-input]")
    private WebElement inputName;

    @FindBy(css = "#teamTypeSelect")
    private WebElement selectTeamType;


    public CreateTeamOverlay(WebDriver driver) {
        super(driver);
    }

    public CreateTeamOverlay setValues(String name, String type) {
        inputName.sendKeys(name);

        click(selectTeamType);
        String chosenType = "div[data-test-id=header-create-team-type-input-".concat(type).concat("]");
        WebElement createTeam = driver.findElement(By.cssSelector(chosenType));
        click(createTeam);

        WebElement continueButton = driver.findElement(By.cssSelector("footer button[data-test-id=header-create-team-submit-button]"));
        click(continueButton);

        return this;
    }

    public CreateTeamOverlay setDescription(String desc) {
        inputName.sendKeys(desc);
        return this;
    }


    public TeamPage skipAddMembers() {
        click(skipMembersButton);
        return new TeamPage(driver);
    }
}
