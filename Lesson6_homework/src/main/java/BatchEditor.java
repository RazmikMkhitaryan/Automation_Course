import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Driver.DriverSetup.getDriver;

public class BatchEditor extends BasePage {
    private By download = By.cssSelector("[class='toolbarItem-0-2-115']");

    @Override
    public String Url() {
        return BASE_URL + "/create/batch";
    }

    public void downloadImages() {
        changeTab(1);
        WeitHelper.getInstance().waitForVisibilityOfElement(download);
        click(download);
    }
}