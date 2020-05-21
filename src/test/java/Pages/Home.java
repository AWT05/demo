package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Home {
    private final static String TEAM_NAME = "Hello new team3!";
    private final static String ADD_BUTTON_XPATH = "//*[@id=\"header\"]/div[2]/button[1]/span";
    private final static String CREATE_TEAM_CSS = "button[data-test-id=header-create-team-button]";
    private final static String TEAM_NAME_CLASS_NAME = "_1CLyNodCAa-vQi";
    private final static String TEAM_TYPE_XPATH = "//*[@id=\"teamTypeSelect\"]/div/div";
    private final static String CONTINUE_CREATE_TEAM_CSS = "._2MgouXHqRQDP_5";
    private final static String SKIP_TEAM_MEMBER_CSS = ".eg0KI5SqghoOFd";
    private WebDriver drivers;
    private WebDriverWait wait;

    @FindBy(xpath = ADD_BUTTON_XPATH)
    WebElement AddButton;

    @FindBy(css = CREATE_TEAM_CSS)
    WebElement CreateTeamButton;

    @FindBy(className = TEAM_NAME_CLASS_NAME)
    WebElement TeamNameInput;

    @FindBy(xpath = TEAM_TYPE_XPATH)
    WebElement TeamTypeMenu;

    @FindBy(css = CONTINUE_CREATE_TEAM_CSS)
    WebElement ContinueTeamCreationButton;

    @FindBy(css = SKIP_TEAM_MEMBER_CSS)
    WebElement SkipAddMemberTeamButton;

    public Home(WebDriver driver) {
        this.drivers = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(drivers, this);

    }

    public void addButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(AddButton));
        AddButton.click();
    }

    public void createBasicTeam() {
        addButtonClick();
        CreateTeamButton.click();
        TeamNameInput.sendKeys(TEAM_NAME);
        TeamTypeMenu.click();

        List<WebElement> options = drivers.findElements(By.cssSelector("._38pq5NbRWAG39y"));

        for (WebElement option : options) {
            if (option.getText().equals("Education")) {
                option.click();
                ContinueTeamCreationButton.click();
                wait.until(ExpectedConditions.elementToBeClickable(SkipAddMemberTeamButton));
                SkipAddMemberTeamButton.click();
                break;
            }
        }
    }
}
