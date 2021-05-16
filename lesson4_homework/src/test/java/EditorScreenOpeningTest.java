import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getDriver;

/**@Before test is creating user_key and log in with it
 * @Test is about uploading image in editors screen, with asserts :)
 */

public class EditorScreenOpeningTest {
    @AfterTest
    public void driverQuit() {
        // getDriver().quit();
    }

    @BeforeTest
    public void logIn() {
        AvatarPage avatarPage = new AvatarPage();
        Cookie cookie = new Cookie("user_key", "f783a943-e4c0-4b5d-93e6-e838aebb54c2");
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();
        assertTrue(avatarPage.isAvatarDisplayed(), "User Not Found !!!");


    }

    @Test
    public void goToEditorScreen() {
        AvatarPage avatarPage = new AvatarPage();
        avatarPage.uploadImage("image.jpeg");
        assertTrue(avatarPage.editorScreenOpens(), "Uploading Failed !!!");
    }


}
