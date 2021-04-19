package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {

    private FWW_Home homePage;
//    private FWW_Forums forumsPage;
//    private FWW_BattleFieldTours battleFieldToursPage;
//    private FWW_Battles battlesPage;
//    private FWW_TheItalianFront theItalianFrontPage;

    final WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public FWW_Home getHomePage() {
        return (homePage == null) ? homePage = new FWW_Home(driver) : homePage;
    }
}
