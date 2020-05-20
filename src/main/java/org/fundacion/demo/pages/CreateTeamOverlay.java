package org.fundacion.demo.pages;

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
    private WebElement typeSelect;


    public CreateTeamOverlay(WebDriver driver) {
        super(driver);
    }

    public CreateTeamOverlay setValues(String name, String type) {

        inputName.sendKeys(name);
        typeSelect.click();
        driver.findElement(By.cssSelector("div[data-test-id=header-create-team-type-input-".concat(type).concat("]"))).click();
        driver.findElement(By.cssSelector("footer button[data-test-id=header-create-team-submit-button]")).click();

        return this;
    }

    public CreateTeamOverlay continueCreation() {
        continueCreation.click();
        return this;
    }

    public TeamPage skipAddMembers() {
        skipMembersButton.click();
        return new TeamPage(driver);
    }
}
