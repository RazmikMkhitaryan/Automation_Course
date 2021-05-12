import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class TheFirstTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/razmkhitaryan/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://picsartstage2.com");
        //driver.get("https://picsart.com");
    }

    @AfterMethod
    public void tearDown() {
        // driver.quit();
    }

    @Test
    public void firstTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        // loginPage.typeUsername("smart_offer");
        loginPage.typeUsername("replayeditor");
        //   loginPage.typePassword("Lusin86");
        loginPage.typePassword("123456");
        loginPage.clickSignInButton();
        loginPage.isAvatarDisplayed();
        assertTrue(driver.getCurrentUrl().contains("/create"), "user was not logged in");
        assertTrue(loginPage.isUserLoggedIn(), "User was not logged in!");
    }


}
