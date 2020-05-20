package org.fundacion.demo.examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumWaits {

    private static final String PAGE_URL = "https://google.com";

    //this test must fail
    @Test
    public void implicitWaitWithCSSSelector() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(PAGE_URL);
        //css selector using name
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("Anime wallpapers");
        //css selector using class, inside a div and then inside a input
        driver.findElement(By.cssSelector(".FPdoLc.tfB0Bf .gNO89b")).click();
        //no existing element, using css selector id
        //driver.findElement(By.cssSelector("#implicitTimeTests")).click();
        //in case of build fail this instructions do not execute and the browser keeps open
        driver.close();
        driver.quit();
    }

    @Test
    public void explicitWaitWithXpath() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get(PAGE_URL);
        //xpath using name
        driver.findElement(By.xpath("//input[@name = 'q']")).sendKeys("facebook");
        driver.getTitle();
        //xpath using class
        driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']/center/input[@class='gNO89b']")).click();
        //no existing element, using xpath id
        WebElement element = wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//div[@id='explicitTimeTest']")));
        driver.close();
        driver.quit();
    }

}
