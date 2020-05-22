package managepage.team;

import managepage.MobileBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamSettings extends MobileBasePage {

    @FindBy(css = "div.window-module.u-gutter span")
    private WebElement deleteTeamButton;

    @FindBy(css = "input.js-confirm.full.negate")
    private WebElement confirmDeleteButton;

    public void selectDeleteTeam(){
        action.clickButton(deleteTeamButton);
    }

    public void confirmDeleteTeam(){
        action.clickButton(confirmDeleteButton);
    }
}
