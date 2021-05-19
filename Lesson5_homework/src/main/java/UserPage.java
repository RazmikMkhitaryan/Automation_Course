import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static setup.DriverSetup.getDriver;

public class UserPage extends BasePage {
    private By challenges = By.linkText("Challenges");
    private By discovery = By.cssSelector("[data-test='headerNavigation-navigationListItem-Discover']");
    private By gridItems = By.cssSelector("[class*='card card']");
    private By button = By.cssSelector(".c-get-the-app-popup.js-prevent-default-event.primary-big-btn");
    private By qrCode = By.id("qrcode");

    WaitHelper waitHelper = new WaitHelper();


    public UserPage() {

        open(getUrl());
    }


    public String getUrl() {

        return BASE_URL + "/create";
    }


    public void goToDiscovery() {
        waitHelper.waitForElementDisplay(discovery);
        List<WebElement> element = getDriver().findElements(discovery);

        Actions actions = new Actions(getDriver());
        actions.moveToElement(element.get(element.size() - 1)).click().build().perform();
    }

    public void clickOnChallanges() {
        waitHelper.waitForElementBeClickable(challenges);
        click(challenges);
    }

    public void selectChallenge() {
        waitHelper.waitForElementDisplay(gridItems);
        List<WebElement> element = getDriver().findElements(gridItems);

        click(element.get(element.size() - 1));
    }

    public void clickOnButton() {
        waitHelper.waitForElementDisplay(button);
        click(button);
    }

    public boolean isVisibleQrCode() {
        if (find(qrCode).isDisplayed()) {
            return true;
        }
        return false;
    }
}