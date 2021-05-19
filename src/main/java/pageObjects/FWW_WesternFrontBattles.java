package pageObjects;

import cucumber.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.CommonFunctions;

import java.lang.reflect.InvocationTargetException;

public class FWW_WesternFrontBattles {

    // Cstor
    public FWW_WesternFrontBattles(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /*
     * Links to the Western Front battles
     */
    @FindBy(linkText = "Siege of Antwerp")
    private WebElement wfSiegeOfAntwerp;

    @FindBy(linkText = "Battle of the Ardennes")
    private WebElement wfBattleoftheArdennes;

    @FindBy(linkText = "First Battle of Champagne")
    private WebElement wfFirstBattleofChampagne;

    @FindBy(linkText = "Second Battle of Ypres")
    private WebElement wfSecondBattleofYpres;

    @FindBy(linkText = "Battle of Verdun")
    private WebElement wfBattleofVerdun;

    @FindBy(linkText = "Battle of the Somme")
    private WebElement wfBattleoftheSomme;

    @FindBy(linkText = "Battle of Flers-Courcelette")
    private WebElement wfBattleofFlers_Courcelette;

    @FindBy(linkText = "Battle of Cambrai")
    private WebElement wfBattleofCambrai;

    @FindBy(linkText = "Third Battle of the Aisne")
    private WebElement wfThirdBattleoftheAisne;

    @FindBy(linkText = "Battle of Epehy")
    private WebElement wfBattleofEpehy;


    /*
     * Methods to select the links to the Western Front battles
     */
    public void clickSiegeofAntwerpLink(){
        CommonFunctions.clickLink(wfSiegeOfAntwerp);
    }

    public void clickBattleoftheArdennesLink(){
        CommonFunctions.clickLink(wfBattleoftheArdennes);
    }

    public void clickFirstBattleofChampagneLink(){
        CommonFunctions.clickLink(wfFirstBattleofChampagne);
    }

    public void clickSecondBattleofYpresLink(){
        CommonFunctions.clickLink(wfSecondBattleofYpres);
    }

    public void clickBattleofVerdunLink(){
        CommonFunctions.clickLink(wfBattleofVerdun);
    }

    public void clickBattleoftheSommeLink(){
        CommonFunctions.clickLink(wfBattleoftheSomme);
    }

    public void clickBattleofFlers_CourceletteLink(){
        CommonFunctions.clickLink(wfBattleofFlers_Courcelette);
    }

    public void clickBattleofCambraiLink(){
        CommonFunctions.clickLink(wfBattleofCambrai);
    }

    public void clickThirdBattleoftheAisneLink(){
        CommonFunctions.clickLink(wfThirdBattleoftheAisne);
    }

    public void clickBattleofEpehyLink(){
        CommonFunctions.clickLink(wfBattleofEpehy);
    }


    // Create a collection of class webelements and determine which method to call
    public void clickWesternFrontBattlePageLink(String link, WebDriver driver) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<FWW_WesternFrontBattles> b = FWW_WesternFrontBattles.class;
        java.lang.reflect.Method[] methods = b.getDeclaredMethods();
        java.lang.reflect.Constructor<FWW_WesternFrontBattles> bc = b.getConstructor(WebDriver.class);
        FWW_WesternFrontBattles battles = bc.newInstance(driver);

        link = link.replace(" ", "");
        //TODO: add logic to replace "_" with "-"
        if(link.contains("-")) link = link.replace("-", "_");

        for (int ctr = 0; ctr < methods.length; ctr++){
            if(methods[ctr].toString().contains(link)){
                java.lang.reflect.Method m = b.getMethod(methods[ctr].getName());
                m.invoke(battles);
                return;
            }
        }
    }

}
