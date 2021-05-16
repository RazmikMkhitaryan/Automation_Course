import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class AvatarPage extends BasePage {
    private By avatarImageLocation = By.cssSelector("[class='root-0-2-589 pa-uiLib-headerProfileInfo-avatar']");
    private By uploadIconInput = By.cssSelector("[accept='image/jpeg, image/png, image/gif']");
    private By goldIteminEditorScreen = By.cssSelector("[data-test='get_gold']");

    public AvatarPage() {
        driver.get(BASE_URL);
    }


    public boolean isAvatarDisplayed() {
        WebElement avatarIcon = new WebDriverWait(driver, 40)
                .until(ExpectedConditions.visibilityOfElementLocated((avatarImageLocation)));
        return isDisplayed(find(avatarImageLocation));
    }


    public void uploadImage(String path) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        WebElement uploadIcon = new WebDriverWait(driver, 40)
//                .until(ExpectedConditions.visibilityOfElementLocated((uploadIconInput)));
        String ImagePath = System.getProperty("user.dir") + File.separator + path;
        type(find(uploadIconInput), ImagePath);
    }


    public boolean editorScreenOpens() {

        WebElement uploadIcon = new WebDriverWait(driver, 40)
                .until(ExpectedConditions.visibilityOfElementLocated((goldIteminEditorScreen)));
        return isDisplayed(find(goldIteminEditorScreen));
    }

}
