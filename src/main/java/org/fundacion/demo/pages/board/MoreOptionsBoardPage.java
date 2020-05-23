package org.fundacion.demo.pages.board;

import org.fundacion.demo.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MoreOptionsBoardPage extends PageObject {

    @FindBy(css = "a.board-menu-navigation-item-link.js-close-board")
    private WebElement closeBoard;

    @FindBy(css = "div.pop-over input[value=\"Close\"]")
    private WebElement confirmClose;

    public MoreOptionsBoardPage(WebDriver driver) {
        super(driver);
    }

    public BoardPage closeBoard() {
        click(closeBoard);
        click(confirmClose);
        return new BoardPage(driver);
    }
}
