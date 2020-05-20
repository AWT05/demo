package managepage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.ManageDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MobileBasePage {


    protected WebDriver driver;
    protected WebDriverWait wait;

    public MobileBasePage() {
        driver = ManageDriver.getInstance().getWebDriver();
        wait = ManageDriver.getInstance().getWebDriverWait();
        PageFactory.initElements(driver, this);
    }

    public void setInputField(By locator, String content) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(content);
    }

    public void clickButton(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void selectListWebElement(String webElementItem, List<WebElement> webElementList){
        /*Select selectList = new Select(driver.findElement(By.cssSelector("._38pq5NbRWAG39y")));
        selectList.selectByVisibleText(typeTeam);*/
        for(WebElement type : webElementList){
            if(type.getText().equals(webElementItem)) {
                ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(type));
                type.click();
                break;
            }
        }
    }


}
