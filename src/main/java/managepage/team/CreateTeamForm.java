package managepage.team;

import managepage.MobileBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateTeamForm extends MobileBasePage {

    @FindBy(css = "._1f6hQ1rpgO5o-J ._1CLyNodCAa-vQi")//id
    private WebElement teamNameTextBox;

    @FindBy(css = ".css-dmzcl._1T1MG_BX1zeaq8")
    private WebElement teamTypeMenu;

    @FindBy(css = "._2vrbr9OyhcQOwQ ._15aIJYNKhrO4vB")
    private WebElement teamDescriptionTextArea;

    @FindBy(css = "._38pq5NbRWAG39y")
    private WebElement chooseTeamType;

    @FindBy(css = "._3UeOvlU6B5KUnS.X1P6DVryq8CYGC._2MgouXHqRQDP_5")
    private WebElement continueButton;

    @FindBy(css = ".fullWidthButton")
    private WebElement inviteButton;

    @FindBy(css = ".autocomplete-input")
    private WebElement emailTextBox;

    public void fillTeamName(String name) {
        action.setInputField(teamNameTextBox, name);
    }

    public void selectTeamTypeMenu(String item) {
        action.clickButton(teamTypeMenu);
        wait.until(ExpectedConditions.elementToBeClickable(chooseTeamType));
        driver.findElement(By.xpath("//li[contains(text(), '".concat(item).concat("')]"))).click();
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
}
