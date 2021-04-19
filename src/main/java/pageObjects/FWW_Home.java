package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import utility.CommonFunctions;

import java.lang.reflect.InvocationTargetException;

public class FWW_Home {
    //final WebDriver driver;

    public FWW_Home(WebDriver driver){
        PageFactory.initElements(driver, this);
        //this.driver = driver;
    }

    @FindBy(linkText = "First World War Forum")
    private WebElement fwwHomePageFirstWorldWarForum;

    @FindBy(linkText = "Battlefield Tours")
    private WebElement fwwBattlefieldTours;

    @FindBy(linkText = "Battles")
    private WebElement fwwBattles;

    public void clickFirstWorldWarForumLink(){
        //CommonFunctions.clickLink(fwwHomePageFirstWorldWarForum);
        fwwHomePageFirstWorldWarForum.click();
    }

    public void clickBattlefieldToursLink(){
        //CommonFunctions.clickLink(fwwBattlefieldTours);
        fwwBattlefieldTours.click();
    }

    public void clickBattlesLink(){
        //CommonFunctions.clickLink(fwwBattles);
        fwwBattles.click();
    }

    //https://www.tutorialspoint.com/list-methods-of-a-class-using-java-reflection
    //https://www.admfactory.com/execute-method-using-reflection-in-java
    // Create a collection of class webelements and determine which method to call
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
    }}
