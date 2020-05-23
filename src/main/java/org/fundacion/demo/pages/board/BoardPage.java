package org.fundacion.demo.pages.board;

import org.fundacion.demo.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardPage extends PageObject {
    @FindBy(css = "p.delete-container a")
    private WebElement deleteContainer;

    @FindBy(css = "div.no-back input[value=\"Delete\"]")
    private WebElement deleteConfirm;


    public BoardPage(WebDriver driver) {
        super(driver);
    }

    public void permanentlyDelete() {
        click(deleteContainer);
        click(deleteConfirm);
    }
}
