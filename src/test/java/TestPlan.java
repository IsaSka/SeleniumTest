import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Failed login to Hano.")
    public static void attemptLogin(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        webForm.enterDatabaseName();
        webForm.enterUsername();
        webForm.enterPassword();
        webForm.pressLoginBtn();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.verifyAlertFailed();
    }

    @Test(testName = "Find Hano Logo.")
    public static void findHanoLogo() {
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        webForm.findLogo();
    }

    @Test(testName = "Check title")
    public static void matchingTitle() {
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        webForm.readTitle();
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}