package managepage.team;

import managepage.MobileBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateTeamForm extends MobileBasePage {

    @FindBy(css = "input[data-test-id='header-create-team-name-input']")//id
    private WebElement teamNameTextBox;

    @FindBy(css = "div[data-test-id='header-create-team-type-input'] > div")
    private WebElement teamTypeMenu;

    @FindBy(css = "textarea[id*='create-team-org-description']")
    private WebElement teamDescriptionTextArea;

    @FindBy(css = "button[data-test-id*='create-team-submit-button']")
    private WebElement continueButton;

    @FindBy(css = "button.autocomplete-btn")
    private WebElement inviteButton;

    @FindBy(css = "input.autocomplete-input")
    private WebElement emailTextBox;

    @FindBy(css = "a[data-test-id='show-later-button']")
    private WebElement inviteMembersLatter;

    public void fillTeamName(String name) {
        action.setInputField(teamNameTextBox, name);
    }

    public void selectTeamTypeMenu(String item) {
        action.clickButton(teamTypeMenu);
        WebElement selectType = driver.findElement(By.
                cssSelector("div[data-test-id='header-create-team-type-input-".concat(item).concat("'] li")));
        wait.until(ExpectedConditions.elementToBeClickable(selectType));
        selectType.click();
    }

    public void fillTextArea(String description) {
        action.setInputField(teamDescriptionTextArea, description);
    }

    public void continueButtonAction() {
        action.clickButton(continueButton);
    }

    public void inviteButtonAction() {
        action.clickButton(inviteButton);
    }

    public void fillEmailTexBox(String email) {
        action.setInputField(emailTextBox, email);
    }

    public void inviteMembersLatterButton() {
        action.clickButton(inviteMembersLatter);
    }
}
