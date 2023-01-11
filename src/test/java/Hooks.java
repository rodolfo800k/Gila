import constants.Constants;
import driver.Browser;
import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoanManagerPage;
import pages.LoginPage;
import utils.PropertiesUtils;

import java.util.UUID;

public  class Hooks {



    @Before
    public void setup(){
        Browser browser = Browser.valueOf(PropertiesUtils.readProperty("browser", Constants.TEST_PROPERTIES));
        DriverFactory.driver = DriverFactory.initializeDriver(browser);
        DriverFactory.webDriverWait = new WebDriverWait(DriverFactory.getDriver(), Constants.TIMEOUT);
        DriverFactory.getDriver().get(Constants.LOGIN_URL);
    }

    @After(order= 1)
    public void takeScreenshotOnFailure(Scenario scenario){
        String scenarioName= scenario.getName();
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "img/png", scenarioName + UUID.randomUUID().toString() );
        }
    }

    @After(order = 0)
    public void tearUp() throws InterruptedException {
         new LoanManagerPage(DriverFactory.getDriver()).doLogout();
         DriverFactory.getWebDriverWait().until(ExpectedConditions.visibilityOf(new LoginPage(DriverFactory.getDriver()).getLoanProLogo()));
        if( DriverFactory.getDriver() != null){
            DriverFactory.getDriver().close();
            DriverFactory.getDriver().quit();
        }
    }
}
