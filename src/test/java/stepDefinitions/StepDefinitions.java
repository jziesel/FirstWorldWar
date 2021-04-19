package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    private static WebDriver driver = null;

    @Given("the user lands on the WWI page")
    public void the_user_lands_on_the_wwi_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("Given the user lands on the WWI page.");

        FirefoxOptions options = new FirefoxOptions();
        //options.setHeadless(true);
        options.setHeadless(false);
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\JZiesel\\geckodriver260\\geckodriver.exe");
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.firstworldwar.com/index.htm");
    }

    @When("clicks the {string} link")
    public void clicks_the_link(String link) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("When the user clicks the " + link + " link.");

        driver.findElement(By.linkText(link)).click();
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
