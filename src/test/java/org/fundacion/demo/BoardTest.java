package org.fundacion.demo;

import org.fundacion.demo.pages.login.LoginPage;
import org.fundacion.demo.pages.menus.MenuBoardsPage;
import org.fundacion.demo.pages.teams.TeamPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fundacion.demo.DriverFactory.getChromeDriver;

public class BoardTest {

    private MenuBoardsPage menuBoards;
    private TeamPage teamPage;

    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(getChromeDriver());
        menuBoards = loginPage
                .setEmail("lucero.quiroga@fundacion-jala.org")
                .setPassword("11111111ocho")
                .submit()
                .openMenuBoards();
    }

    @Test
    public void deleteBoards() {
        menuBoards
                .selectFirts()
                .moreMenuOptions()
                .closeBoard()
                .permanentlyDelete();
    }

    @AfterMethod
    public void quit() {
        getChromeDriver().quit();
    }
}
