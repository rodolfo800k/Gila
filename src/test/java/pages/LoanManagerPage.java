package pages;

import constants.Constants;
import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverUtils;

import java.sql.SQLOutput;
import java.util.List;

public class LoanManagerPage extends BasePage{

    public LoanManagerPage(WebDriver webDriver){
        super(webDriver);
    }

    private final String modalWindowLocatorString = "form[name='contractForm']";
    private By  passwordUpdateModalLocator = By.cssSelector(modalWindowLocatorString);

    @FindBy(css= modalWindowLocatorString)
    private WebElement passwordUpdateModal;

    @FindBy(css = "md-dialog > form > md-toolbar > div > button")
    private WebElement closeUpdateModalWindow;

    @FindBy(id ="navigationLeft")
    private WebElement loansMenu;

    @FindBy(css = "[class='profile-pic ng-scope layout-align-center-center layout-row']")
    private WebElement avatar;

    @FindBy(css = "button[title='New Loan']")
    private WebElement newLoanButton;

    @FindBy(css = "[class='new-lp-icon new-lp-icon-excel-reports md-lptheme-theme'] > svg")
    private WebElement reportsButton;

    @FindBy(css = "[class='tenant-title truncate ng-binding']")
    private WebElement tenantTitleElement;

    @FindBy(id = "select_value_label_157")
    private WebElement selectLoanStatus;

     @FindBy(id = "select_option_214")
    private WebElement approvedStatus;

     @FindBy(css = "#loanManagerTable > tbody > tr")
     private List<WebElement> resultsTableRows;

     private By statusCell = By.cssSelector("td:nth-child(25)");

    @FindBy(linkText= "Logout")
    private WebElement logoutButton;

    public void dismissPasswordUpdateModalIfVisible(){
        try{
            DriverFactory.getWebDriverWait().until(ExpectedConditions.visibilityOf(passwordUpdateModal));
            DriverFactory.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(closeUpdateModalWindow));
            closeUpdateModalWindow.click();
            DriverFactory.getWebDriverWait().until(ExpectedConditions.urlToBe(Constants.LOAN_MANAGER_URL));
            DriverUtils.waitForAjaxCalls();
            if(DriverFactory.getDriver().findElements(passwordUpdateModalLocator).size() != 0){
                System.out.println("modal was not closed, retrying");
                closeUpdateModalWindow.sendKeys(Keys.ENTER);
            }
        }catch (NoSuchElementException | TimeoutException ex){
            System.out.println("Update Password Modal Not Displayed");
        }
    }

    public boolean validateLoanManagerPageControls(){

        DriverFactory.getWebDriverWait().until(ExpectedConditions.visibilityOf(tenantTitleElement));
        DriverFactory.getWebDriverWait().until(ExpectedConditions.visibilityOf(reportsButton));
        return  tenantTitleElement.isDisplayed()&&
                reportsButton.isDisplayed() &&
                newLoanButton.isDisplayed() &&
                avatar.isDisplayed() &&
                loansMenu.isDisplayed();

    }

    public void searchLoanByApprovedStatus(){
        System.out.println("Search by approved status starting 1");
        DriverFactory.getWebDriverWait().until(ExpectedConditions.visibilityOf(selectLoanStatus));
        System.out.println("About to click on loan search");
        selectLoanStatus.click();
        DriverFactory.getWebDriverWait().until(ExpectedConditions.visibilityOf(approvedStatus));
        System.out.println("Search by approved status starting 1");
        approvedStatus.click();

    }

    public boolean validateLoanStatusAreApproved(){
        DriverFactory.getWebDriverWait().until(ExpectedConditions.textToBe(statusCell, Constants.APPROVED));
        DriverUtils.scrollToElement(DriverFactory.getDriver().findElement(statusCell));
       return resultsTableRows.stream()
               .map(row -> row.findElement(statusCell))
               .map(cell -> cell.getText()).peek(System.out::println)
               .allMatch(value -> value.equalsIgnoreCase( Constants.APPROVED));
    }

    public void doLogout(){
        avatar.click();
        logoutButton.click();
    }

}
