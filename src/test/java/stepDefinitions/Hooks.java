package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.*;
//import org.apache.tools.ant.util.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {

    TestContext testContext;
    private String currentAppURL;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void SetUp() {
		/*What all you can perform here
			Starting a webdriver
			Setting up DB connections
			Setting up test data
			Setting up browser cookies
			Navigating to certain page
			or anything before the test
		*/
    }

    @BeforeStep
    public void grabCurrentURLToCompare(){
        currentAppURL = testContext.getWebDriverManager().getDriver().getCurrentUrl();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if(!currentAppURL.contentEquals(testContext.getWebDriverManager().getDriver().getCurrentUrl())) {
            File screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "screenshot");
        }
    }

    @After
    public void TearDown() {
        testContext.getWebDriverManager().closeDriver();
    }

}