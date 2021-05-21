import org.openqa.selenium.By;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static Driver.DriverSetup.getDriver;

public class CreatePage extends BasePage {
    private By uploadButton = By.cssSelector("[accept='image/jpeg, image/png, image/gif']");


    @Override
    public String Url() {
        return BASE_URL + "/create";
    }

    public void openCreatePage() {
        getDriver().manage().deleteAllCookies();
        getDriver().navigate().refresh();
        open(Url());
    }

    public void uploatImages() {
        List<String> images = new ArrayList<>();
        images.add(System.getProperty("user.dir") + File.separator + "src/main/resources/image.jpeg");
        images.add(System.getProperty("user.dir") + File.separator + "src/main/resources/image2.jpeg");
        images.add(System.getProperty("user.dir") + File.separator + "src/main/resources/image3.jpeg");
        type(uploadButton, images.get(0) + "\n" + images.get(1) + "\n" + images.get(2));

    }


    public void uploatImage() {
        type(uploadButton, System.getProperty("user.dir") + File.separator + "src/main/resources/image.jpeg");
    }

}
