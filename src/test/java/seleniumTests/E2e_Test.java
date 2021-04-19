package seleniumTests;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class E2e_Test {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        FirefoxOptions options = new FirefoxOptions();
        //options.setHeadless(true);
        options.setHeadless(false);
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\JZiesel\\geckodriver260\\geckodriver.exe");
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.firstworldwar.com/index.htm");
        Thread.sleep(3500);
        driver.quit();
    }
}
