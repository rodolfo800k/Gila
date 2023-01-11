package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static WebDriver initializeDriver(Browser browser){
        switch (browser){
            case CHROME:
                return driver = new ChromeFactory().createDriver();

            default:
                return driver = new FirefoxFactory().createDriver();
        }

    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriverWait getWebDriverWait(){
        return webDriverWait;
    }


}
