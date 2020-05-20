package managepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.ManageDriver;
import webdriver.WebDriverAction;

public class MobileBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverAction action;

    public MobileBasePage() {
        driver = ManageDriver.getInstance().getWebDriver();
        wait = ManageDriver.getInstance().getWebDriverWait();
        action = new WebDriverAction(driver, wait);
        PageFactory.initElements(driver, this);
    }

}
