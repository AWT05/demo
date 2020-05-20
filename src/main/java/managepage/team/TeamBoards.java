package managepage.team;

import managepage.MobileBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class TeamBoards extends MobileBasePage {

    @FindBy(css = "._2BCgr50F6ruIZ5")
    private WebElement teamName;

    @FindBy(css = "._3Ea60-0nkKsQ4D")
    private WebElement teamDescription;

    @FindBy(css = ".tabbed-pane-nav-item-button.js-org-account")
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
