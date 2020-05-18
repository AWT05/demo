package org.fundacion.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.fundacion.demo.pages.GoogleSearchPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    private static final String PAGE_URL = "https://google.com";

    @Test
    public void googleSearch(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get(PAGE_URL);
        GoogleSearchPage.textBox_search(driver).sendKeys("youtube");
        GoogleSearchPage.button_search(driver).click();
        driver.close();
        driver.quit();
    }
}
