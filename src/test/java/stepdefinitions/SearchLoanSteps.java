package stepdefinitions;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoanManagerPage;
import pages.LoginPage;

public class SearchLoanSteps{

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private LoanManagerPage loanManagerPage = new LoanManagerPage(DriverFactory.getDriver());

    @Given("User logs in to the application {string} {string}")
    public void user_logs_in(String username, String password) throws InterruptedException {
        Assert.assertTrue(loginPage.validateLoginPageLayout());
        loginPage.doLogin(username, password);
        loanManagerPage.dismissPasswordUpdateModalIfVisible();

    }

    @When("User lands on Loan Manager Page with all controls present")
    public void user_lands_on_loan_manager_page(){
        Assert.assertTrue(loanManagerPage.validateLoanManagerPageControls());
    }

    @And("User searches for approved loans")
    public void user_searches_for_approved_loans(){
        loanManagerPage.searchLoanByApprovedStatus();
    }

    @Then("All the retrieved loans must have status as approved")
    public void all_retrieved_loans_are_approved(){
        Assert.assertTrue(loanManagerPage.validateLoanStatusAreApproved());
    }


}
