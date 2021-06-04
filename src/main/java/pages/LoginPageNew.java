package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.Log;

public class LoginPageNew {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailText;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passText;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signinLink;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement signinButton;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signoutLink;


    public LoginPageNew(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickSigninLink() {
        signinLink.click();
    }

    public void verifyLoginPage() {
        emailText.isDisplayed();
        passText.isDisplayed();
        signinButton.isDisplayed();
    }

    public void enterEmail(String email) {
        emailText.sendKeys(email);
    }

    public void enterPassword(String pass) {
        passText.sendKeys(pass);

    }

    public void clickSignin() {
        signinButton.click();
    }

    public void verifyLogin() {
        signoutLink.isDisplayed();

    }

}
