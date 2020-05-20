package managepage;

import org.openqa.selenium.By;

public class Home extends MobileBasePage {

    By createButton = By.cssSelector("[name=add]");
    By createTeamButton = By.cssSelector("._2jR0BZMM5cBReR[data-test-id=header-create-team-button]");

    public void selectCreateTeam() {
        action.clickButton(createButton);
        action.clickButton(createTeamButton);
    }


}
