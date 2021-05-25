import com.google.gson.JsonObject;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.UUID;

import static DriverSetup.Setup.getDriver;

public class CommentTest extends TestBase {
    private String key;
    private String key2 = "1cd61327-24ed-4874-a557-a658f36936e2";
    private String myImage = "354400546054201";
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
    public void writeComment() throws IOException, InterruptedException {
        //  JsonObject image = ApiHelper.uploadPhoto(key);
        //  new ImageBrowserPage(image.get("id").getAsString());


        //  JsonObject user = ApiHelper.createUser(UUID.randomUUID().toString());
        //    key2 = user.get("response").getAsJsonObject().get("key").getAsString();
        LoginPage loginPage = new LoginPage();
        Cookie cookie = new Cookie("user_key", key2);
        getDriver().manage().addCookie(cookie);
        getDriver().navigate().refresh();


        // ApiHelper.addComment(key2, image.get("id").getAsString());
        ApiHelper.addComment(key2, myImage);
        //  new ImageBrowserPage(image.get("id").getAsString());
        new ImageBrowserPage(myImage);
    }

}