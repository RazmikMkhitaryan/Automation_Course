import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getDriver;

public class TheFirstTest {
    @BeforeMethod
    public void setup() {
        // driver = new ChromeDriver();
        //driver.get("https://picsart.com");
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @Test
    public void firstTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginButton();
        loginPage.typeUsername("replayeditor");
        loginPage.typePassword("123456");
        loginPage.clickSignInButton();
        loginPage.isAvatarDisplayed();
        assertTrue(getDriver().getCurrentUrl().contains("/create"), "user was not logged in");
        assertTrue(loginPage.isUserLoggedIn(), "User was not logged in!");
    }

    @Test
    public void loginWithKey() {
        // driver.manage().getCookies();
        //driver.manage().getCookieNamed("user_key");
        LoginPage loginPage = new LoginPage();
        Cookie cookie = new Cookie("user_key", "f783a943-e4c0-4b5d-93e6-e838aebb54c2");
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();
        assertTrue(loginPage.isUserLoggedIn(), "User was not logged in!");

    }

}
