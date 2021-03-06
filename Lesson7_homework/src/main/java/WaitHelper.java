import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static DriverSetup.Setup.getDriver;
public class WaitHelper {
    private static final int DEFAULT_TIMEOUT = 10;

    public static WaitHelper getInstance() {
        WaitHelper waitHelper = new WaitHelper();
        return waitHelper;
    }

    public WaitHelper waitForElementDisplay(By location) {
        try {
            WebElement until = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated((location)));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator was not displayed" + location.toString());
        }
    }

    public WaitHelper waitForBeClickable(By location) {
        try {
            WebElement until = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable((location)));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with provided locator was not displayed" + location.toString());
        }
    }


}

