package managepage.team;

import managepage.MobileBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class TeamBoards extends MobileBasePage {

    @FindBy(css = "div.tabbed-pane-header-details h1")
    private WebElement teamName;

    @FindBy(css = "div.tabbed-pane-header-details p")
    private WebElement teamDescription;

    @FindBy(css = "a.tabbed-pane-nav-item-button.js-org-account")
    private WebElement settingsButton;

    public String getTeamName() {
        return action.getElementText(teamName);
    }

    public String getDescription(){
        return action.getElementText(teamDescription);
    }

    public void selectTeamSettings(){
        action.clickButton(settingsButton);
    }
}
