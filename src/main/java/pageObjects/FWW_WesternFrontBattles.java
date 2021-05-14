package pageObjects;

import cucumber.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.CommonFunctions;

import java.lang.reflect.InvocationTargetException;

public class FWW_WesternFrontBattles {

    public FWW_WesternFrontBattles(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Siege of Antwerp")
    private WebElement wfSiegeOfAntwerp;


    public void clickSiegeofAntwerpLink(){
        CommonFunctions.clickLink(wfSiegeOfAntwerp);
    }

    // Create a collection of class webelements and determine which method to call
    public void clickWesternFrontBattlePageLink(String link, WebDriver driver) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<FWW_WesternFrontBattles> b = FWW_WesternFrontBattles.class;
        java.lang.reflect.Method[] methods = b.getDeclaredMethods();
        java.lang.reflect.Constructor<FWW_WesternFrontBattles> bc = b.getConstructor(WebDriver.class);
        FWW_WesternFrontBattles battles = bc.newInstance(driver);

        link = link.replace(" ", "");

        for (int ctr = 0; ctr < methods.length; ctr++){
            if(methods[ctr].toString().contains(link)){
                java.lang.reflect.Method m = b.getMethod(methods[ctr].getName());
                m.invoke(battles);
                return;
            }
        }
    }

}
