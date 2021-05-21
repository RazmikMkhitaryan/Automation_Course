import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserPage extends BasePage {
    private By imagesGrid = By.cssSelector("[data-page-source='user_profile']");
    private By likeButton = By.cssSelector("[class*='c-like-button like']");

    @Override
    public String Url() {
        return BASE_URL + "/u/joonieedits";
    }

    public void openUserPage() {
        open(Url());
    }

    public void openFirtsImage() {
        WeitHelper.getInstance().waitForVisibilityOfElement(imagesGrid);
        List<WebElement> all = findAll(imagesGrid);
        click(all.get(0));
    }


    public boolean like() {
        WeitHelper.getInstance().waitForVisibilityOfElement(likeButton);
        if (find(likeButton).getAttribute("class").contains("active")) {
            System.out.println("Image was liked before ------ i did unlike ");
        } else {
            System.out.println("I like this photo");
        }
        try {
            click(likeButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
