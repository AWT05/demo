package org.fundacion.demo;

import Pages.Home;
import Pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamTests {
    WebDriver driver;

    @BeforeMethod
    public void init() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        this.driver = driver;
        driver.manage().window().setSize(new Dimension(414, 736));
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    @Test
    public void testLoginTrelloByPage() {

        Login LoginPage = new Login(driver);
        LoginPage.logInIntoTrello("carledriss3", "P@ssw0rd");
//        assertEquals("home", page.getText());
    }

    @Test
    public void testCreateTeamMobileTrelloByPage() {

        Login LoginPage = new Login(driver);
        LoginPage.logInIntoTrello();
        Home HomePage = new Home(driver);
        HomePage.createBasicTeam();
    }
}

