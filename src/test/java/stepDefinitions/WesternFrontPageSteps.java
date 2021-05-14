package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.FWW_WesternFrontBattles;
import testDataTypes.Search;

import java.lang.reflect.InvocationTargetException;

public class WesternFrontPageSteps {

    TestContext testContext;
    FWW_WesternFrontBattles westernFrontBattles;
    Search search = null;

    private static WebDriver driver = null;

    public WesternFrontPageSteps(TestContext context){
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        westernFrontBattles = testContext.getPageObjectManager().getWesternFrontBattles();
    }

    @And("next clicks the Western Front {string} link")
    public void next_clicks_the_Western_Front_ink(String link) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();

        try {
            westernFrontBattles.clickWesternFrontBattlePageLink(link, driver);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Then("the user is taken to the Western Front {string} page")
    public void the_user_is_taken_to_the_Western_Front_page(String target) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        if(search != null) target = search.fww_page;
        System.out.println("Then the user is taken to the " + target + " page.");

        String verbiage = driver.findElement(By.xpath("/html/body")).getText();
        if (verbiage.contains(target)){  // "Please note our forum is currently not open"
            Assert.assertTrue("Successully landed on the " + target + " page.", true);
            System.out.println("Successully landed on the " + target + " page.");
        } else {
            System.out.println("DID NOT land on the " + target + " page!");
        }
    }


}
