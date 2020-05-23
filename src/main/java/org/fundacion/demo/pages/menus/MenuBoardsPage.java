package org.fundacion.demo.pages.menus;

import org.fundacion.demo.pages.PageObject;
import org.fundacion.demo.pages.board.MenuBoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class MenuBoardsPage extends PageObject {

    @FindBy(css = "div[data-react-beautiful-dnd-droppable]>div a")
    private WebElement miniBoard;

    public MenuBoardsPage(WebDriver driver) {
        super(driver);
    }

    public MenuBoardPage selectFirts() {
        click(miniBoard);
        return new MenuBoardPage(driver);
    }
}
