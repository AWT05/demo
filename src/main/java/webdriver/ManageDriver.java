package webdriver;

import config.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ManageDriver {

    private static final String BASE_URL = Environment.getInstance().getBaseUrl();
    private static final Integer WAIT_TIME = 10;
    private final WebDriver driver;
    private WebDriverWait wait;
    private static ManageDriver instance;


    private ManageDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().setSize(new Dimension(414, 736));
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
    }

    public static ManageDriver getInstance(){
        if (instance == null){
            instance = new ManageDriver();
        }
        return instance;
    }

    public WebDriver getWebDriver(){
        return driver;
    }

    public WebDriverWait getWebDriverWait(){
        wait = new WebDriverWait(driver, WAIT_TIME);
        return wait;
    }
}
