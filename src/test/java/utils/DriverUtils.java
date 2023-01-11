package utils;

import driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class DriverUtils {

    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitForAjaxCalls(){
        JavascriptExecutor js = ((JavascriptExecutor) DriverFactory.getDriver());
        DriverFactory.getWebDriverWait().until(x -> js.executeScript("return window.jQuery != undefined && jQuery.active == 0"));
    }
}
