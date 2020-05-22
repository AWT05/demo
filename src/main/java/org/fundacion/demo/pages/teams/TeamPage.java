package org.fundacion.demo.pages.teams;

import org.fundacion.demo.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class TeamPage extends PageObject {

    private static final String ATTRIBUTE_INNER_TEXT = "innerText";

    @FindBy(css = ".tabbed-pane-header-details h1")
    private WebElement name;

    @FindBy(css = ".tabbed-pane-nav-item a[data-tab=settings]")
    private WebElement settings;

    public TeamPage(final WebDriver driver) {
        super(driver);
    }

    public String getName() {
        wait.until(ExpectedConditions.attributeToBeNotEmpty(name, ATTRIBUTE_INNER_TEXT));
        return name.getText();
    }

    public TeamSettings goToSettings() {
        click(settings);
        return new TeamSettings(driver);
    }
}
