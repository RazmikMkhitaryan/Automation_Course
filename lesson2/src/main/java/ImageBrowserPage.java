import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverSetup;

import static setup.DriverSetup.getDriver;

public class ImageBrowserPage extends BasePage {

    public WebElement getLikeIcon() {
        return likeIcon;
    }

    @FindBy(css = ".actions-section .notifier-hover-toggle .like")
    private WebElement likeIcon;

  //  private final By likeIconLocation = By.cssSelector("");

    public ImageBrowserPage () {
        PageFactory.initElements(DriverSetup.getDriver(),this);
    }

    public ImageBrowserPage (String imageID) {
        open(BASE_URL + "/i/" + imageID);
        PageFactory.initElements(DriverSetup.getDriver(),this);

    }

    @Override
    public String getUrl() {
        return null;
    }

    public void clickOnLikeIcon() {
        click(likeIcon);
    }

//    public void clickLike() {
//        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", find(likeIcon));
//    }



    public boolean isImageLiked() {
        return likeIcon.getAttribute("class").contains("active");
    }
}