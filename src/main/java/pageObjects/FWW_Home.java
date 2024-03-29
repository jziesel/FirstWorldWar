package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;
import testDataTypes.Search;
import utility.CommonFunctions;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class FWW_Home {
    //final WebDriver driver;
    private static WebDriver driver = null;

    public FWW_Home(WebDriver driver){
        PageFactory.initElements(driver, this);
        //this.driver = driver;
        FWW_Home.driver = driver;
    }

    @FindBy(linkText = "First World War Forum")
    private WebElement fwwHomePageFirstWorldWarForum;

    @FindBy(linkText = "Battlefield Tours")
    private WebElement fwwBattlefieldTours;

    @FindBy(linkText = "Battles")
    private WebElement fwwBattles;

    @FindBy(name = "q")
    private WebElement search;

    @FindBy(name = "btnG")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='rso']")
    private WebElement firstSearchResultOnGoogle;


    public void clickFirstWorldWarForumLink(){
        //CommonFunctions.clickLink(fwwHomePageFirstWorldWarForum);
        fwwHomePageFirstWorldWarForum.click();
    }

    public void clickBattlefieldToursLink(){
        CommonFunctions.clickLink(fwwBattlefieldTours);  // using the static CommonFunctions method
        //fwwBattlefieldTours.click();  // using tbe @FindBy via PageFactory
    }

    public void clickBattlesLink(){
        //CommonFunctions.clickLink(fwwBattles);
        fwwBattles.click();
    }

    //https://www.tutorialspoint.com/list-methods-of-a-class-using-java-reflection
    //https://www.admfactory.com/execute-method-using-reflection-in-java
    // Create a collection of class webelements and determine which method to call
    // using Reflection (see links above)
    public void clickHomePageLink(String link, WebDriver driver) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<FWW_Home> h = FWW_Home.class;
        java.lang.reflect.Method[] methods = h.getDeclaredMethods();
        java.lang.reflect.Constructor<FWW_Home> hc = h.getConstructor(WebDriver.class);
        FWW_Home home = hc.newInstance(driver);

        link = link.replace(" ", "");

        for (int ctr = 0; ctr < methods.length; ctr++){
            if(methods[ctr].toString().contains(link)){
                java.lang.reflect.Method m = h.getMethod(methods[ctr].getName());
                m.invoke(home);
                return;
            }
        }
    }

    public void enterSearchText(Search s) {
        search.clear();
        search.sendKeys(s.criteria);
    }

    public void clickSearchButton() {
        searchButton.click();
        //Thread.sleep(1750);
        Wait.untilJqueryIsDone(driver);
    }

    public void verifySearchResultsPage(Search s) {
        //TODO: Need to implement WaitProperty here...
        CommonFunctions.verifyCorrectLandingPage(driver, s.g_result);
    }

    public void clickFirstSearchResultsLink(Search s) {
        //firstSearchResultOnGoogle.click();
        ArrayList<WebElement> collLinks;
        //collLinks = (ArrayList<WebElement>) googleCollectionOfSearchResultsLinks.findElements(By.linkText(s.g_result));
        collLinks = (ArrayList<WebElement>) firstSearchResultOnGoogle.findElements(By.partialLinkText(s.criteria));
        for (WebElement link : collLinks) {
            try {
                CommonFunctions.highLighterMethod(driver, link);
                if(link.getAttribute("text").contains(s.g_result)){
                    link.click();
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Wait.untilJqueryIsDone(driver);
    }

}
