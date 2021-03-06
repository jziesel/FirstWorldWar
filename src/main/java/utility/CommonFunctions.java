package utility;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonFunctions {

    public CommonFunctions() {
    }

    public static void clickLink(WebElement link) {
        try {
            if (link != null) {
                link.click();
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static void verifyCorrectLandingPage(WebDriver driver, String target) {
        String verbiage = driver.findElement(By.xpath("/html/body")).getText();
        if (verbiage.contains(target)) {  // "Please note our forum is currently not open"
            //Assert.assertTrue("Successully landed on the " + target + " page.", true);
            System.out.println("Successully landed on the " + target + " page.");
        } else {
            System.out.println("DID NOT land on the " + target + " page!");
        }
    }

    public static void highLighterMethod(WebDriver driver, WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i <= 4; i++) {
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
            Thread.sleep(575);
            js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
        }

    }
}