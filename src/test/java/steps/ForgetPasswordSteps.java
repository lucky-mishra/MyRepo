package steps;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ForgetPasswordPage;
import pages.LoginPageNew;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import util.Log;
import util.Testlink;

public class ForgetPasswordSteps {

    private WebDriver driver;
    String notes = null;
    String result = null;
    String counter;
    String testCase;

    private ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage(DriverFactory.getDriver());

    @When("click on forget password link")
    public void click_on_forget_password_link() {
        try {
            //System.out.println("enter valid username");
            forgetPasswordPage.clickForgetPassword();
            Log.info("click on forget password");
            //loginPage.enterUesrname(userName);
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Then("forget password screen should get open")
    public void forget_password_screen_should_get_open() throws TestLinkAPIException {
        try {
            testCase = "SCP--1022";
            //System.out.println("click on signin");
            forgetPasswordPage.verifyForgetPasswordPage();
            Log.info("click on back to login");
            result = TestLinkAPIResults.TEST_PASSED;
            notes = "Executed successfully";
        } catch (Exception e) {
            e.printStackTrace();
            result = TestLinkAPIResults.TEST_FAILED;
            notes = "Execution failed";
            Log.error(e.getMessage());
            Assert.fail(e.getMessage());
        } finally {
            Testlink.reportResult(Testlink.testProject, Testlink.testPlan, testCase, Testlink.build, notes, result);
        }

    }

    @When("enter valid {string}")
    public void enter_valid(String userName) {
        try {
            //System.out.println("enter valid username");
            forgetPasswordPage.enterUesrname(userName);
            Log.info("Enter user name as " + userName);
            //loginPage.enterUesrname(userName);
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @When("click on submit button")
    public void click_on_submit_button() {
        try {
            System.out.println("click on signin");
            forgetPasswordPage.clickSubmit();
            Log.info("click on submit  ");

        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Then("success message should display")
    public void success_message_should_display() throws TestLinkAPIException {
        try {
            testCase = "SCP--1023";
            //System.out.println("click on signin");
            forgetPasswordPage.verifyValidUsername();
            Log.info("Success message displayed");
            Log.info("Success message displayed");
            result = TestLinkAPIResults.TEST_PASSED;
            notes = "Executed successfully";
        } catch (Exception e) {
            e.printStackTrace();
            result = TestLinkAPIResults.TEST_FAILED;
            notes = "Execution failed";
            Log.error(e.getMessage());
            Assert.fail(e.getMessage());
        } finally {
            Testlink.reportResult(Testlink.testProject, Testlink.testPlan, testCase, Testlink.build, notes, result);
        }
    }

    @When("click on back to login link")
    public void click_on_back_to_login_link() {
        try {
            forgetPasswordPage.clickBack();
            Log.info("click on back to login  ");

        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

}


