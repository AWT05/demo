package org.fundacion.demo.examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {

	@Test
	public void testLoginTrello() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().setSize(new Dimension(414, 736));
		//driver.manage().window().

		driver.get("https://trello.com/login");

		driver.findElement(By.cssSelector("#user")).sendKeys("carledriss3");
		driver.findElement(By.cssSelector("#password")).sendKeys("P@ssw0rd");
		driver.findElement(By.cssSelector("input.account-button")).click();

		driver.close();

		driver.quit();
	}

}
