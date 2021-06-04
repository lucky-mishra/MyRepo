package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.Log;
import util.PropertyReader;

public class ForgetPasswordPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Forgot password')]")
    private WebElement forgetPassword;

    @FindBy(xpath = "//a[contains(text(),'Back to login')]")
    private WebElement backToLogin;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement successFP;

    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickForgetPassword() {
        forgetPassword.click();
    }

    public void verifyForgetPasswordPage() {
        backToLogin.isDisplayed();
    }

    public void enterUesrname(String userName) {
        username.sendKeys(userName);
    }

    public void clickSubmit() {
        submitButton.click();

    }

    public void verifyValidUsername() {
        successFP.isDisplayed();
        String expectedText = new PropertyReader().readProperty("succ_forgetpassword");
        String acctualTest = successFP.getText();
        Assert.assertEquals(expectedText, acctualTest);
    }

    public void clickBack() {
        backToLogin.click();
    }

    public void verifyLoginPage() {
        forgetPassword.isDisplayed();
    }
}
