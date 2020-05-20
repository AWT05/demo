package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private final static String URL = "https://trello.com/login";
    private final static String USERNAME = "carledriss3";
    private final static String PASSWORD = "P@ssw0rd";
    private WebDriver driver;

    @FindBy(css = "#user")
    WebElement Username;

    @FindBy(css = "#password")
    WebElement Password;

    @FindBy(css = "input.account-button")
    WebElement logInGreenButton;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logInIntoTrello() {
        driver.get(URL);
        Username.sendKeys(USERNAME);
        Password.sendKeys(PASSWORD);
        logInGreenButton.click();
    }

//    public void quit() {
//        driver.quit();
//    }
}
