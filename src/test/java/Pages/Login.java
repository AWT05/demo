package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends PageObject{
    private final static String URL = "https://trello.com/login";
    private final static String USERNAME = "carledriss3";
    private final static String PASSWORD = "P@ssw0rd";
    private WebDriver driver;

    @FindBy(css = "#user")
    private WebElement Username;

    @FindBy(css = "#password")
    private WebElement Password;

    @FindBy(css = "input.account-button")
    private WebElement logInGreenButton;

    public Login(WebDriver driver) {
        super(driver);
    }

//    public Login(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    public void logInIntoTrello() {
        drivers.get(URL);
        Username.sendKeys(USERNAME);
        Password.sendKeys(PASSWORD);
        logInGreenButton.click();

    }

    public void logInIntoTrello(String userName,String password) {
        drivers.get(URL);
        Username.sendKeys(userName);
        Password.sendKeys(password);
        logInGreenButton.click();
    }
}
