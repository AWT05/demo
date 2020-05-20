package managepage.team;

import managepage.MobileBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamSettings extends MobileBasePage {

    @FindBy(css = ".window-module.u-gutter span")
    private WebElement deleteTeamButton;

    @FindBy(css = ".js-confirm.full.negate")
    private WebElement confirmDeleteButton;

    public void selectDeleteTeam(){
        action.clickButton(deleteTeamButton);
    }

    public void confirmDeleteTeam(){
        action.clickButton(confirmDeleteButton);
    }
}
