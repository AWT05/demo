package org.fundacion.demo.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

    private static WebElement element = null;

    public static WebElement textBox_search(WebDriver driver) {
        element = driver.findElement(By.cssSelector(".gLFyf.gsfi"));//css class
        return element;
    }

    public static WebElement button_search(WebDriver driver) {
        element = driver.findElement(By.cssSelector(".FPdoLc.tfB0Bf [name = btnK]"));//by class, by name
        return element;
    }
}
