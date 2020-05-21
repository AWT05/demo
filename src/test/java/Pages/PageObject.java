package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    protected WebDriver drivers;
    protected WebDriverWait wait;
    public PageObject(WebDriver driver) {
        this.drivers = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(drivers, this);
    }
}
