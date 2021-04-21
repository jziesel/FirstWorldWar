package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pageObjects.FWW_Battles;

import java.lang.reflect.InvocationTargetException;

public class BattlesPageSteps {

    TestContext testContext;
    FWW_Battles battlesPage;

    private static WebDriver driver = null;

    public BattlesPageSteps(TestContext context) {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        battlesPage = testContext.getPageObjectManager().getBattlesPage();
    }

    @And("next clicks the {string} link")
    public void next_clicks_the_link(String link) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();

        try {
            battlesPage.clickBattlePageLink(link, driver);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }


}
