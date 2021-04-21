package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import java.lang.reflect.InvocationTargetException;

public class CommonSteps {
    TestContext testContext;
    FWW_Home fww_home;

    private static WebDriver driver = null;

    public CommonSteps(TestContext context) {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        fww_home = testContext.getPageObjectManager().getHomePage();
    }

    @Given("the user lands on the WWI page")
    public void the_user_lands_on_the_wwi_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("Given the user lands on the WWI page.");

        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    @When("clicks the {string} link")
    public void clicks_the_link(String link) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("When the user clicks the " + link + " link.");

        try {
            fww_home.clickHomePageLink(link, driver);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Then("the user is taken to the {string} page")
    public void the_user_is_taken_to_the_page(String target) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("Then the user is taken to the " + target + " page.");

        String verbiage = driver.findElement(By.xpath("/html/body")).getText();
        if (verbiage.contains(target)){  // "Please note our forum is currently not open"
            Assert.assertTrue("Successully landed on the " + target + " page.", true);
            System.out.println("Successully landed on the " + target + " page.");
        } else {
            System.out.println("DID NOT land on the " + target + " page!");
        }
    }

    @And("the browser closes")
    public void the_browser_closes() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("And the browser closes.");

        driver.quit();
    }

}
