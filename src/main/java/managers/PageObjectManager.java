package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {

    private FWW_Home homePage;
    private FWW_Forums forumsPage;
    private FWW_BattleFieldTours battleFieldToursPage;
    private FWW_Battles battlesPage;
    private FWW_TheItalianFront theItalianFrontPage;

    final WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public FWW_Home getHomePage() {
        return (homePage == null) ? homePage = new FWW_Home(driver) : homePage;
    }

    public FWW_Forums getForumsPage(){
        return (forumsPage == null) ? forumsPage = new FWW_Forums(driver) : forumsPage;
    }

    public FWW_BattleFieldTours getBattleFieldToursPage(){
        return (battleFieldToursPage == null) ? battleFieldToursPage = new FWW_BattleFieldTours(driver) : battleFieldToursPage;
    }

    public FWW_Battles getBattlesPage(){
        return (battlesPage == null) ? battlesPage = new FWW_Battles(driver) : battlesPage;
    }

    public FWW_TheItalianFront getTheItalianFrontPage(){
        return (theItalianFrontPage == null) ? theItalianFrontPage = new FWW_TheItalianFront(driver) : theItalianFrontPage;
    }

}
