package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Home {
    private final static String TEAM_NAME = "Hello new team!";
    private final static String ADD_BUTTON_XPATH = "//*[@id=\"header\"]/div[2]/button[1]/span";
    private final static String CREATE_TEAM_CSS = "button[data-test-id=header-create-team-button]";
    private final static String TEAM_NAME_CLASS_NAME = "_1CLyNodCAa-vQi";
    private final static String TEAM_TYPE_XPATH = "//*[@id=\"teamTypeSelect\"]/div/div";
    private ChromeDriver drivers;
    private WebDriverWait wait;


    @FindBy(xpath = ADD_BUTTON_XPATH)
    WebElement AddButton;

    @FindBy(css = CREATE_TEAM_CSS)
    WebElement CreateTeamButton;

    @FindBy(className = TEAM_NAME_CLASS_NAME)
    WebElement TeamNameInput;

    @FindBy(xpath = TEAM_TYPE_XPATH)
    WebElement TeamTypeMenu;

    public Home(ChromeDriver driver) {
        this.drivers = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(drivers, this);

    }

    public void addButtonClick() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        wait.until(ExpectedConditions.elementToBeClickable(AddButton));
        AddButton.click();
    }

    public void createTeam() {
        addButtonClick();
        CreateTeamButton.click();
        TeamNameInput.sendKeys(TEAM_NAME);
        TeamTypeMenu.click();
//        wait.until(ExpectedConditions.elementToBeClickable());
//        List<WebElement> options=driver.findElementsByXPath("/html/body/div[14]/div/section/div/nav/ul/li[2]/button/p");
        List<WebElement> options = drivers.findElementsByCssSelector("div[data-test-id=header-create-team-type-input-");
//        wait.until(ExpectedConditions.attributeToBeNotEmpty(name, "innerText"));

        for (WebElement option : options) {
            if (option.getText().equals("Education")) {
                option.click();
                break;
            }
        }
    }


}
