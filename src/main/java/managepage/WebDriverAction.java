package managepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.ManageDriver;

public class WebDriverAction {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebDriverAction(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void setInputField(By locator, String content) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(content);
    }

    public void clickButton(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void clickButton(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void selectListWebElement(String webElementItem, List<WebElement> webElementList){
        /*Select selectList = new Select(driver.findElement(By.cssSelector("._38pq5NbRWAG39y")));
        selectList.selectByVisibleText(typeTeam);*/
        for(WebElement type : webElementList){
            if(type.getText().equals(webElementItem)) {
                wait.until(ExpectedConditions.elementToBeClickable(type));
                type.click();
                break;
            }
        }
    }


}
