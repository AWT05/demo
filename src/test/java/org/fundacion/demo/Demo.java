package org.fundacion.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo {

    @Test
    public void testLoginTrello() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().setSize(new Dimension(414, 736));

        driver.get("https://trello.com/login");

        driver.findElement(By.cssSelector("#user")).sendKeys("carledriss3");
        driver.findElement(By.cssSelector("#password")).sendKeys("P@ssw0rd");
        driver.findElement(By.cssSelector("input.account-button")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/button[1]/span")).click();
        driver.findElement(By.xpath("/html/body/div[14]/div/section/div/nav/ul/li[2]/button/p")).click();
        driver.findElement(By.className("_1CLyNodCAa-vQi")).sendKeys("Hello new team!");

        driver.findElement(By.xpath("//*[@id=\"teamTypeSelect\"]/div/div")).click();

//        List<WebElement> options = driver.findElementsByXPath("/html/body/div[14]/div/section/div/nav/ul/li[2]/button/p");
//        for (WebElement option : options) {
//            if (option.getText().equals("Education")) {
//                option.click();
//                break;
//            }
//        }
        driver.close();
        driver.quit();
    }
}
