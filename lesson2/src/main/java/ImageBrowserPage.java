import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static setup.DriverSetup.getDriver;

public class ImageBrowserPage extends BasePage {

    private final By likeIconLocation = By.cssSelector(".actions-section .notifier-hover-toggle .like");

    public ImageBrowserPage () {
    }

    public ImageBrowserPage (String imageID) {
        open(BASE_URL + "/i/" + imageID);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public void clickOnLikeIcon() {
        WaitHelper.getInstance().waitForElementDisplay(likeIconLocation);
        click(likeIconLocation);
    }

    public void clickLike() {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", find(likeIconLocation));
    }



    public boolean isImageLiked() {
        return find(likeIconLocation).getAttribute("class").contains("active");
    }
}