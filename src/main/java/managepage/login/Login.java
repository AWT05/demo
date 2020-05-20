package managepage.login;

import config.Environment;
import managepage.MobileBasePage;
import org.openqa.selenium.By;

public class Login extends MobileBasePage {

    private static final String USER_NAME = Environment.getInstance().getUserName();
    private static final String USER_PASSWORD = Environment.getInstance().getPassword();

    By userTextBox = By.cssSelector("#user");
    By passTextBox = By.cssSelector("[name=password]");
    By loginButton = By.cssSelector("input.account-button");

    public void login() {
        action.setInputField(userTextBox, USER_NAME);
        action.setInputField(passTextBox, USER_PASSWORD);
        action.clickButton(loginButton);
    }

}
