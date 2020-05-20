package utils;

import managepage.MobileBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdriver.ManageDriver;

public class CommonEvents{


    public static void setInputField(WebElement element, String content) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(content);
    }

    public static void clickButton(WebElement element) {
        ManageDriver.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
