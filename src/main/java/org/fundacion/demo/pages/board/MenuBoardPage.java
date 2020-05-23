package org.fundacion.demo.pages.board;

import org.fundacion.demo.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuBoardPage extends PageObject {
    @FindBy(css = "li a.js-open-more")
    private WebElement moreButton;

    public MenuBoardPage(WebDriver driver) {
        super(driver);
    }

    public MoreOptionsBoardPage moreMenuOptions() {
        click(moreButton);
        return new MoreOptionsBoardPage(driver);
    }
}
