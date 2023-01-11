package driver;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.PropertiesUtils;

public class FirefoxFactory extends BaseFactory {

    @Override
    protected FirefoxOptions createOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.addPreference("browser.private.browsing.autostart", true);
        return firefoxOptions;
    }

    @Override
    public WebDriver createDriver() {
        System.setProperty("webdriver.gecko.driver",PropertiesUtils.readProperty( "geckodriver", Constants.TEST_PROPERTIES));
        FirefoxDriver driver = new FirefoxDriver(createOptions());
        driver.manage().window().maximize();
        return driver;
    }
}
