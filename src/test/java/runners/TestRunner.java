package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//import com.cucumber.listener.Reporter;
//import org.testng.annotations.AfterClass;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/Report.html"},
        monochrome = true,
        tags = "@Regression"
)

public class TestRunner {
}