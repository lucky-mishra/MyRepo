package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import hooks.Hook;

@CucumberOptions(features = {"src/test/java/features/LoginNew.feature"}, monochrome = false,
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun/login_failed.txt","timeline:target/thread-timeline", "steps.StepDetails"},
        glue = {"steps","hooks"},dryRun = false)
public class LoginRunner extends AbstractTestNGCucumberTests {


}
