package driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public abstract class BaseFactory {

    protected abstract MutableCapabilities createOptions();
    protected abstract WebDriver createDriver();
}
