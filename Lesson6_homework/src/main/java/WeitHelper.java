import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Driver.DriverSetup.getDriver;

public class WeitHelper {
    public static final int DEFAULT_TIME = 15;

    public static WeitHelper getInstance() {
        WeitHelper weitHelper = new WeitHelper();
        return weitHelper;
    }

    public WeitHelper waitForVisibilityOfElement(By location) {
        try {
            new WebDriverWait(getDriver(), DEFAULT_TIME).until(ExpectedConditions.visibilityOfElementLocated(location));
            return this;
        } catch (WebDriverException e) {
            throw new Error("No such element found" + location.toString());
        }
    }

    public WeitHelper waitElementBeClickable(By location) {
        try {
            new WebDriverWait(getDriver(), DEFAULT_TIME).until(ExpectedConditions.elementToBeClickable(location));
            return this;
        } catch (WebDriverException e) {
            throw new Error("No such element found" + location.toString());
        }

    }


}
