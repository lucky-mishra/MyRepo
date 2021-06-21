package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.Log;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver initBrowser(String browser) throws MalformedURLException {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
            Log.info("Chrome browser launched");
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
            Log.info("Firefox browser launched");
        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            tlDriver.set(new InternetExplorerDriver());
            Log.info("IE browser launched");
        } else if (browser.equalsIgnoreCase("chrome-headleass")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("window-size=1349,344");
            tlDriver.set(new ChromeDriver(options));
            Log.info("Chrome headeless browser launched");
        }
        else if (browser.equalsIgnoreCase("grid")) {
            //WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setCapability("Platform", Platform.WIN10);
            options.setCapability("Browser", BrowserType.CHROME);
            tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options));
            Log.info("Grid Chrome browser launched");
        }else {
            Log.error("can't read browser type");
            System.out.println("can't read browser type");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
