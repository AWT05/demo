package org.fundacion.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    private static final int TEN_SECONDS = 10;
    protected final WebDriverWait wait;
    protected final WebDriver driver;

    public PageObject(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TEN_SECONDS);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TEN_SECONDS), this);
    }

    /**
     * Makes click in the web element.
     *
     * @param element web element.
     */
    public void click(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
