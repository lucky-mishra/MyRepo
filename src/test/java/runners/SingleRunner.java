package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun/rerun.txt","timeline:target/thread-timeline","steps.StepDetails"},
        glue = {"steps"})
public class SingleRunner {
}
