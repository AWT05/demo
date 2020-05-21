package org.fundacion.demo;

import Pages.Home;
import Pages.Login;
import org.testng.annotations.Test;

public class TeamTests extends FunctionalTest {

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
        HomePage.createBasicTeam("Education");
        //Falta limpiar el ambiente
    }
}

