import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static setup.DriverSetup.getDriver;

public class CreatePage extends BasePage{
    private By uploadButton = By.cssSelector("[accept='image/jpeg, image/png, image/gif']");
    private By products = By.cssSelector("[data-test='headerNavigation-navigationListItem-Products']");
    private By seeAll = By.cssSelector("[href='/photo-editing-tools']");

    @Override
    public String getUrl() {
        return BASE_URL + "/create";
    }

    public void openCreatePage(){
        open(getUrl());
    }

    public void uploadphoto(){
        type(uploadButton,"/Users/razmkhitaryan/Desktop/lessons/image.png");
    }


    public void goToProducts(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(find(products)).build().perform();
        WaitHelper.getInstance().waitForElementDisplay(seeAll);
        click(seeAll);
    }

}
