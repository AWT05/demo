package managepage;

import org.openqa.selenium.By;
import utils.CommonEvents;

public class Login extends MobileBasePage {

    private static final String USER_NAME = "carledriss3";
    private static final String USER_PASSWORD = "P@ssw0rd";

    /*@FindBy(css = "#user")//id
    private WebElement userTextBox;*/

    By userTextBox = By.cssSelector("#user");
    By passTextBox = By.cssSelector("[name=password]");
    By loginButton = By.cssSelector("input.account-button");

    /*public void login() {
        //driver.findElement(userTextBox).sendKeys(USER_NAME);
        CommonEvents.setInputField(userTextBox, USER_NAME);
        CommonEvents.setInputField(passTextBox, USER_PASSWORD);
        CommonEvents.clickButton(loginButton);
    }*/

    public void login(){
        setInputField(userTextBox, USER_NAME);
        setInputField(passTextBox, USER_PASSWORD);
        clickButton(loginButton);
    }


}
