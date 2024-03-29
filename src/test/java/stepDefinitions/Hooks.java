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
    private Hooks hooks;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void SetUp(Scenario scenario) {
		/*What all you can perform here
			Starting a webdriver
			Setting up DB connections
			Setting up test data
			Setting up browser cookies
			Navigating to certain page
			or anything before the test
		*/
        hooks = this;
        testContext.setScenario(scenario);
        testContext.setHooks(hooks);
    }

    @BeforeStep
    public void grabCurrentURLToCompare(){
        currentAppURL = testContext.getWebDriverManager().getDriver().getCurrentUrl();
    }

    /* So far, this 'Hook' is being used in the HomePageSteps class method
    * .the_user_verifies_there_are_five_rotating_banner_articles(). This hook
    * will take a screen capture after cycling through the Scenario Outline
    * data elements (rows) as part of the verification of the test. */
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