package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/ForgetPassword.feature"}, monochrome = false,
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun/forgetPassword_failed.txt","timeline:target/thread-timeline", "steps.StepDetails"},
        glue = {"steps","hooks"},dryRun = false)
public class ForgetPasswordRunner extends AbstractTestNGCucumberTests {
}
