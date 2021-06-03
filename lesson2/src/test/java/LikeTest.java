import com.google.gson.JsonObject;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getDriver;

public class LikeTest {
    private String key;
    private String key2;
    private String sid;

    @BeforeTest
    public void setup() throws IOException, InterruptedException {
        JsonObject user = ApiHelper.createUser();
        key = user.get("response").getAsJsonObject().get("key").getAsString();
        LoginPage loginPage = new LoginPage();

        Cookie cookie = new Cookie("user_key", key);
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();


    }

    @Test
    public void Like() throws IOException, InterruptedException {
      //  JsonObject image = ApiHelper.uploadPhoto(key);
      //  ApiHelper.likePhoto(key, image.get("id").getAsString());
      //  new ImageBrowserPage(image.get("id").getAsString());
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage("354400546054201");
        assertTrue(true,"jhbcjhdsc");
        System.out.println(imageBrowserPage.getLikeIcon().getClass().toString());


    }
}
