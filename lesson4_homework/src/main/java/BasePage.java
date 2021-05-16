import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static setup.DriverSetup.getDriver;

public abstract class BasePage {
    protected WebDriver driver;
    public static final String BASE_URL = "https://picsart.com";

    public BasePage() {
        this.driver = getDriver();
    }


    public WebElement find(By location) {
        return driver.findElement(location);
    }


    public void click(WebElement element) {
        element.click();
    }

    public void click(By location) {
        find(location).click();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void type(By location, String text) {
        find(location).sendKeys(text);
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }


}
