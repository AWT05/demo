package org.fundacion.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TeamPage extends PageObject {

    @FindBy(css = ".tabbed-pane-header-details h1")
    WebElement name;

    @FindBy(css = ".tabbed-pane-nav-item a[data-tab=settings]")
    WebElement settings;

    public TeamPage(WebDriver driver) {
        super(driver);
    }

    public String getName() {
        wait.until(ExpectedConditions.attributeToBeNotEmpty(name, "innerText"));
        return name.getText();
    }

    public TeamSettings goToSettings() {
        settings.click();
        return new TeamSettings(driver);
    }
}
