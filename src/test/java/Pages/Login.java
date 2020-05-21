package Pages;

import org.fundacion.demo.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageObject {
    private final static String USERNAME = "carledriss3";
    private final static String PASSWORD = "P@ssw0rd";
    Environment env;

    @FindBy(css = "#user")
    private WebElement Username;

    @FindBy(css = "#password")
    private WebElement Password;

    @FindBy(css = "input.account-button")
    private WebElement logInGreenButton;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void logInIntoTrello() {
        drivers.get(env.getInstance().getBaseUri().concat("/login"));
        Username.sendKeys(USERNAME);
        Password.sendKeys(PASSWORD);
        logInGreenButton.click();
    }

    public void logInIntoTrello(String userName, String password) {
        drivers.get(env.getInstance().getBaseUri().concat("/login"));
        Username.sendKeys(userName);
        Password.sendKeys(password);
        logInGreenButton.click();
    }
}
