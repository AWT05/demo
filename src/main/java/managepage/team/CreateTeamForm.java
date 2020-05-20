package managepage.team;

import managepage.MobileBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.CommonEvents;
import webdriver.ManageDriver;

import java.util.List;

public class CreateTeamForm extends MobileBasePage {

    @FindBy(css = "._1f6hQ1rpgO5o-J ._1CLyNodCAa-vQi")//id
    private WebElement teamNameTextBox;

    @FindBy(css = ".css-dmzcl._1T1MG_BX1zeaq8")
    private WebElement teamTypeMenu;

    @FindBy(css = "._2vrbr9OyhcQOwQ ._15aIJYNKhrO4vB")
    private WebElement teamDescriptionTextArea;

    @FindBy(css = "._38pq5NbRWAG39y")
    private List<WebElement> teamTypeList;

    @FindBy(css = "._3UeOvlU6B5KUnS.X1P6DVryq8CYGC._2MgouXHqRQDP_5")
    private WebElement continueButton;

    @FindBy(css = ".fullWidthButton")
    private WebElement inviteButton;

    @FindBy(css = ".autocomplete-input")
    private WebElement emailTextBox;

    public void fillTeamName(String name) {
        CommonEvents.setInputField(teamNameTextBox, name);
    }

    public void selectTeamTypeMenu(String typeTeam) {
        CommonEvents.clickButton(teamTypeMenu);
        selectListWebElement(typeTeam, teamTypeList);
    }

    public void fillTextArea(String description){
        CommonEvents.setInputField(teamDescriptionTextArea, description);
    }

    public void continueButtonAction(){
        CommonEvents.clickButton(continueButton);
    }

    public void inviteButtonAction(){
        CommonEvents.clickButton(inviteButton);
    }

    public void fillEmailTexBox(String email){
        CommonEvents.setInputField(emailTextBox, email);
    }
}
