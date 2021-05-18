import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getDriver;

public class TheFirstTest {
    @BeforeMethod
    public void setup() {
        // driver = new ChromeDriver();
        //driver.get("https://picsart.com");
//        Cookie cookie1 = new Cookie("we-editor-first-open","true");
//        getDriver().manage().addCookie(cookie1);
//        getDriver().navigate().refresh();
    }

    @AfterMethod
    public void tearDown() {
        //  getDriver().quit();
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
        Cookie cookie1 = new Cookie("we-editor-first-open", "true");
        getDriver().manage().addCookie(cookie1);
        //   getDriver().navigate().refresh();
        // assertTrue(loginPage.isUserLoggedIn(), "User was not logged in!");
        //  Actions actions = new Actions(getDriver());
        loginPage.clickInstagram();
        loginPage.changeTab(1);
        EditorPage editorPage = new EditorPage();
        editorPage.clickOnFit();
        System.out.println(editorPage.getCountOfFit());

    }


    @Test
    public void templatesCount() {
        LoginPage loginPage = new LoginPage();
        login();
        assertTrue(loginPage.isUserLoggedIn(), "User was not logged in!");
        loginPage.clickInstagram();
        loginPage.changeTab(1);
        EditorPage editorPage = new EditorPage();
        editorPage.clickOnFit();
        assertEquals(editorPage.getCountOfFit(), 28, "Templates count is not 28");


    }

    private void login() {
        Cookie cookie = new Cookie("user_key", "f783a943-e4c0-4b5d-93e6-e838aebb54c2");
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();
        Cookie cookie1 = new Cookie("we-editor-first-open", "true");
        getDriver().manage().addCookie(cookie1);
    }


}
