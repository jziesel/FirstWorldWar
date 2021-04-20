package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.CommonFunctions;

import java.lang.reflect.InvocationTargetException;

public class FWW_Forums {

    public FWW_Forums(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "First World War .com")
    private WebElement fwwTheFirstWorldWarDotCom;

    public void clickTheFirstWorldWarDotComLink(){
        CommonFunctions.clickLink(fwwTheFirstWorldWarDotCom);
    }

    // Create a collection of class webelements and determine which method to call
    public void clickForumsPageLink(String link, WebDriver driver) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<FWW_Forums> f = FWW_Forums.class;
        java.lang.reflect.Method[] methods = f.getDeclaredMethods();
        java.lang.reflect.Constructor<FWW_Forums> fc = f.getConstructor(WebDriver.class);
        FWW_Forums forums = fc.newInstance(driver);

        link = link.replace(" ", "");

        for (int ctr = 0; ctr < methods.length; ctr++){
            if(methods[ctr].toString().contains(link)){
                java.lang.reflect.Method m = f.getMethod(methods[ctr].getName());
                m.invoke(forums);
                return;
            }
        }
    }
}