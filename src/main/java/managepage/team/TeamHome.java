package managepage.team;

import managepage.MobileBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamHome extends MobileBasePage {

    @FindBy(css = "._2BCgr50F6ruIZ5")
    private WebElement teamName;

    public String getTeamName(){
        String name= teamName.getText();
        return name;
    }

}
