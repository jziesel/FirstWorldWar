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

    @FindBy(linkText = "The Western Front")
    private WebElement fwwTheWesternFront;

    @FindBy(linkText = "The Eastern Front")
    private WebElement fwwTheEasternFront;

    @FindBy(linkText = "The Gallipoli Front")
    private WebElement fwwTheGallipoliFront;

    @FindBy(linkText = "The Palestine Front")
    private WebElement fwwThePalestineFront;

    @FindBy(linkText = "The Mesopotamian Front")
    private WebElement fwwTheMesopotamianFront;

    @FindBy(linkText = "The African Wars")
    private WebElement fwwTheAfricanWars;

    @FindBy(linkText = "The War at Sea")
    private WebElement fwwTheWarAtSea;

    @FindBy(linkText = "The Far East")
    private WebElement fwwTheFarEast;

    @FindBy(linkText = "All Battles by Date")
    private WebElement fwwAllBattlesByDate;


    public void clickTheItalianFrontLink(){
        CommonFunctions.clickLink(fwwTheItalianFront);
    }

    public void clickTheWesternFrontLink(){
        CommonFunctions.clickLink(fwwTheWesternFront);
    }

    public void clickTheEasternFrontLink(){
        CommonFunctions.clickLink(fwwTheEasternFront);
    }

    public void clickTheGallipoliFrontLink(){
        CommonFunctions.clickLink(fwwTheGallipoliFront);
    }

    public void clickThePalestineFrontLink(){
        CommonFunctions.clickLink(fwwThePalestineFront);
    }

    public void clickTheMesopotamianFrontLink(){
        CommonFunctions.clickLink(fwwTheMesopotamianFront);
    }

    public void clickTheAfricanWarsLink(){
        CommonFunctions.clickLink(fwwTheAfricanWars);
    }

    public void clickTheWarAtSeaLink(){
        CommonFunctions.clickLink(fwwTheWarAtSea);
    }

    public void clickTheFarEastLink(){
        CommonFunctions.clickLink(fwwTheFarEast);
    }

    public void clickAllBattlesByDateLink(){
        CommonFunctions.clickLink(fwwAllBattlesByDate);
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
