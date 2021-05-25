import com.google.gson.JsonObject;
import okhttp3.*;
import org.openqa.selenium.Cookie;
import org.testng.annotations.*;

import java.io.IOException;

import static DriverSetup.Setup.getDriver;
import static org.testng.Assert.assertTrue;

public class HashtagTest {
    private String key;
    private String imageId;

    @BeforeMethod
    public void setup() throws IOException, InterruptedException {
        JsonObject user = ApiHelper.createUser();
        key = user.get("response").getAsJsonObject().get("key").getAsString();
        LoginPage loginPage = new LoginPage();

        Cookie cookie = new Cookie("user_key", key);
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();
        JsonObject photo = ApiHelper.uploadPhoto(key);
        imageId = photo.get("id").getAsString();
        System.out.println("User's user_key is -> " + key);
    }

    /**
     * after test the created user deleted,  EXTRA task successfully done )))
     */
    @AfterMethod
    public void tearDown() throws IOException {
        ApiHelper.deleteUser(key);
        getDriver().navigate().refresh();
    }

    /**
     * This test is about adding hashtag in added image
     */
    @Test
    public void addHashtag() throws IOException, InterruptedException {
        ApiHelper.editHashtag(key, imageId, ImageBrowserPage.HASHTAG);
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(imageId);
        assertTrue(imageBrowserPage.isHashtagAdded(), "hashtag was not added");
    }
}
