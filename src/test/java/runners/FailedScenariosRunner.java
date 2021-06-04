package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"@target/rerun.txt"}, monochrome = true,
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","steps.StepDetails"})
public class FailedScenariosRunner extends AbstractTestNGCucumberTests {


}
