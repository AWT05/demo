package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Home {
    private final static String TEAM_NAME = "Hello new team!";
    private final static String ADD_BUTTON_XPATH = "//*[@id=\"header\"]/div[2]/button[1]/span";
    private final static String CREATE_TEAM_XPATH = "/html/body/div[14]/div/section/div/nav/ul/li[2]/button/p";
    private final static String TEAM_NAME_CLASS_NAME = "_1CLyNodCAa-vQi";
    private final static String TEAM_TYPE_XPATH = "//*[@id=\"teamTypeSelect\"]/div/div";
    private ChromeDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/button[1]/span")
    WebElement AddButton;

    @FindBy(xpath = "/html/body/div[14]/div/section/div/nav/ul/li[2]/button/p")
    WebElement CreateTeamButton;

    @FindBy(className = "_1CLyNodCAa-vQi")
    WebElement TeamNameInput;

    @FindBy(xpath = "//*[@id=\"teamTypeSelect\"]/div/div")
    WebElement TeamTypeMenu;

    public Home(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addButtonClick() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        AddButton.click();
    }

    public void createTeam() {
        addButtonClick();
        CreateTeamButton.click();
        TeamNameInput.sendKeys(TEAM_NAME);
        TeamTypeMenu.click();
        List<WebElement> options=driver.findElementsByXPath("/html/body/div[14]/div/section/div/nav/ul/li[2]/button/p");
        for(WebElement option:options){
            if(option.getText().equals("Education")){
                option.click();
                break;
            }
        }
    }



}
