package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[class='md-primary button lp-login-btn md-button']")
    private WebElement loginButton;

    @FindBy(id = "loginAngCtrl")
    private WebElement loanProLogo;

    @FindBy(css="div[class='md-title layout-align-center']")
    private WebElement login_Subtitle;

    public void doLogin(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean validateLoginPageLayout(){

        return loanProLogo.isDisplayed() && login_Subtitle.getText().equalsIgnoreCase("Login");
    }

    public WebElement getLoanProLogo(){
        return loanProLogo;
    }

}
