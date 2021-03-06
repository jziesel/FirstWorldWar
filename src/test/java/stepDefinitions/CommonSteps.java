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
import testDataTypes.Search;

import java.lang.reflect.InvocationTargetException;

public class CommonSteps {
    TestContext testContext;
    FWW_Home fww_home;
    Search search = null;

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

    @When("the user enters {string} in the search box")
    public void the_user_enters_in_the_search_box(String searchTopic) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();

        //Search search = FileReaderManager.getInstance().getJsonReader().getSearchByName(searchTopic);
        search = FileReaderManager.getInstance().getJsonReader().getSearchByName(searchTopic);
        fww_home.enterSearchText(search);
    }

    @Then("the user is taken to the {string} page")
    public void the_user_is_taken_to_the_page(String target) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        if(search != null) target = search.fww_page;
        System.out.println("Then the user is taken to the " + target + " page.");

        String verbiage = driver.findElement(By.xpath("/html/body")).getText();
        if (verbiage.contains(target)){  // "Please note our forum is currently not open"
            Assert.assertTrue("Successully landed on the " + target + " page.", true);
            System.out.println("Successully landed on the " + target + " page.");
        } else {
            System.out.println("***** DID NOT land on the " + target + " page! *****");
        }
    }

    @And("the browser closes")
    public void the_browser_closes() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("And the browser closes.");

        // The @After tag in Hooks.class takes care of this...
        //driver.quit();
    }

    @And("clicks the Search button")
    public void clicks_the_button() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        fww_home.clickSearchButton();
    }

    @And("verifies the Google {string} results page")
    public void verifies_the_Google_search_results_page(String searchTopic) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();

        search = FileReaderManager.getInstance().getJsonReader().getSearchByName(searchTopic);
        fww_home.verifySearchResultsPage(search);
    }

    @And("selects the first search result on Google page")
    public void selects_the_first_search_result_on_Google_page(){
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        fww_home.clickFirstSearchResultsLink(search);
    }

}
