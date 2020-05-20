package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void setInputField(WebElement webElement, String content) {
        webElement.clear();
        webElement.sendKeys(content);
    }

    public void clickButton(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void clickButton(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public String getElementText(WebElement webElement) {
        wait.until(ExpectedConditions.attributeToBeNotEmpty(webElement, "innerText"));
        return webElement.getText();
    }
}
