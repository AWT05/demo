package org.fundacion.demo;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class FunctionalTest {
    protected static WebDriver driver;

    @BeforeMethod
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(414, 736));
        System.out.println("Executed BEFORE method");
    }

    @AfterMethod
    public static void tearDown(){
        driver.quit();
        System.out.println("Executed AFTER method");
    }
}
