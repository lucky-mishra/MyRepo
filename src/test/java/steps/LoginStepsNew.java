package steps;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPageNew;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
import util.Log;
import util.PropertyReader;
import util.Testlink;

public class LoginStepsNew {
    private WebDriver driver;
    String notes = null;
    String result = null;
    String counter;
    String testCase;

    private LoginPageNew loginPage = new LoginPageNew(DriverFactory.getDriver());

    @Given("User is on home page")
    public void user_is_on_home_page() {

        System.out.println("open application and home page open");
        String url = new PropertyReader().readProperty("baseurl");
        DriverFactory.getDriver().get(url);

    }

    @When("click on signin link")
    public void click_on_signin_link() {
        try {
            loginPage.clickSigninLink();
            Log.info("click on sign in link");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Then("login page should get open")
    public void login_page_should_get_open() {
        loginPage.verifyLoginPage();
    }

    @Given("enter username as {string}")
    public void enter_username_as(String email) {
        try {
            System.out.println("enter valid username");
            loginPage.enterEmail(email);
            Log.info("Enter user name as " + email);
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            Assert.fail(e.getMessage());
        }

    }

    @Given("enter password as {string}")
    public void enter_password_as(String pass) {
        try {

            System.out.println("enter valid password");
            loginPage.enterPassword(pass);
            Log.info("Enter password as " + pass);
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Given("click signin button")
    public void click_signin_button() throws InterruptedException {
        try {

            System.out.println("click on signin");
            loginPage.clickSignin();
            Log.info("Click on proceed button");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Then("verify that user got logged in")
    public void verify_that_user_got_logged_in() throws TestLinkAPIException {
        try {
            testCase = "DM-1";
            //System.out.println("click on signin");
            loginPage.verifyLogin();
            Log.info("User got logined");
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
}
