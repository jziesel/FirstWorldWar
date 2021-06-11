package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import pageObjects.*;
import selenium.Wait;
import testDataTypes.Search;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class HomePageSteps {
    TestContext testContext;
    FWW_Home fww_home;
    //Search search = null;

    private static WebDriver driver = null;

    public HomePageSteps(TestContext context) {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        fww_home = testContext.getPageObjectManager().getHomePage();
    }

    @Then("the user verifies there are five rotating banner articles")
    public void the_user_verifies_there_are_five_rotating_banner_articles() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();

/*
        text-align: left;
        padding: 0;
        font: bold 1em 'Trebuchet MS', Arial, Sans-serif;
        font-size: 1.5em;
        color: #6297BC;
        margin: 10px 15px;
        height: 15px;
*/
        int ctr = 0;
        HashMap<String, String> linkAndUrl = new HashMap<String, String>();
        WebElement xmlContainer = driver.findElement(By.xpath("//*[@id='main']"));
        List<WebElement> banners = xmlContainer.findElements(By.tagName("h1"));
        for (WebElement banner : banners) {
            // The links use the "height: 15px" style
            if (banner.getCssValue("height").contentEquals("15px")) {
                System.out.println("**** > > " + banner.getText() + " < < ****");

                // Keep collection of link and urls for later
                WebElement link = banner.findElement(By.tagName("a"));
                linkAndUrl.put(banner.getText(), link.getAttribute("href"));

                ctr++;
            }
        }

        if (ctr == 5) {
            Assert.assertTrue("Successfully verified five rotating banners on the home page.", true);

            Iterator iterator = linkAndUrl.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry)iterator.next();
                driver.findElement(By.linkText((String) pair.getKey())).click();
                Wait.untilJqueryIsDone(driver);

                String targetUrl = (String) pair.getValue();
                if (driver.getCurrentUrl().contentEquals(targetUrl)) {
                    System.out.println("Successfully taken to the " + targetUrl + " page");
                } else {
                    System.out.println("!!! Did not land on the expected page: Expected - " + targetUrl + ", " +
                            "Actual: " + driver.getCurrentUrl());
                }

                driver.navigate().back();
                Wait.untilJqueryIsDone(driver);

            }
        } else {
            Assert.fail("!! DID NOT successfully verify five rotating banners. Found: " + ctr + " !!");
        }
    }
}
