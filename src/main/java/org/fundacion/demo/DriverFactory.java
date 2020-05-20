package org.fundacion.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {
        // prevent instantiations
    }

    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void lightScreen() {
        driver.manage().window().setSize(new Dimension(414, 736));
    }
}
