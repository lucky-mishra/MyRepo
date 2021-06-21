package hooks;


import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import steps.StepDetails;
import util.Log;
import util.PropertyReader;
import util.RerunFile;

import java.io.*;
import java.net.MalformedURLException;


public class Hook {
    public DriverFactory driverFactory;
    public WebDriver driver;
    RerunFile rerunFile=new RerunFile();

    @Before(order = 0)
    public void launchBrowser() throws MalformedURLException {
        String browserName = new PropertyReader().readProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.initBrowser(browserName);
    }

    @Before(order = 1)
    public void before(Scenario scenario) {
        Log.info("------------------------------");
        Log.info("Starting - " + scenario.getName());
        Log.info("------------------------------");

    }

    @After(order = 0)
    public void closeDriver() {
        driver.quit();
        Log.info("Closing the driver");
    }

    //@After(order = 1)
    public void gernerateRerun() throws IOException {
        rerunFile.getRerunFile();
        Log.info("Generating rerun.txt");
    }


    @After(order = 2)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.attach(screenshot, "image/png", scenario.getName());
            Log.info("Screnshot Taken" + scenario.getName());
            scenario.attach("/src/main/resources/LogMaster.log","text/plain","Logs");
        }
    }

    @After(order = 3)
    public void after(Scenario scenario) {
        Log.info("------------------------------");
        Log.info(scenario.getName() + " Status - " + scenario.getStatus());
        Log.info("------------------------------");
    }

    //@BeforeStep
    public void doSomethingBeforeStep() {
        Log.info(StepDetails.stepName);
    }

}
