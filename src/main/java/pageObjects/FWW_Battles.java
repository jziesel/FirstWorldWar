package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.CommonFunctions;

import java.lang.reflect.InvocationTargetException;

public class FWW_Battles {

    //final WebDriver driver;

    public FWW_Battles(WebDriver driver){
        PageFactory.initElements(driver, this);
        //this.driver = driver;
    }

    @FindBy(linkText = "The Italian Front")
    private WebElement fwwTheItalianFront;

    public void clickTheItalianFrontLink(){
        CommonFunctions.clickLink(fwwTheItalianFront);
    }

    // Create a collection of class webelements and determine which method to call
    public void clickBattlePageLink(String link, WebDriver driver) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<FWW_Battles> b = FWW_Battles.class;
        java.lang.reflect.Method[] methods = b.getDeclaredMethods();
        java.lang.reflect.Constructor<FWW_Battles> bc = b.getConstructor(WebDriver.class);
        FWW_Battles battles = bc.newInstance(driver);

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
