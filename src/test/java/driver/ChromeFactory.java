package driver;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PropertiesUtils;

public class ChromeFactory extends BaseFactory {

    @Override
     protected   ChromeOptions createOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--incognito");
        return options;
    }

    @Override
    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver" , PropertiesUtils.readProperty( "chromedriver", Constants.TEST_PROPERTIES));
        ChromeDriver driver = new ChromeDriver(createOptions());
        driver.manage().window().maximize();
        return driver;
    }
}
