import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static Driver.DriverSetup.getDriver;

public abstract class BasePage {
    private WebDriver driver;
    public static final String BASE_URL = "https://picsart.com";

    public abstract String Url();

    public void open(String URL) {
        getDriver().get(URL);

    }


    public BasePage() {
        this.driver = getDriver();
    }

    public WebElement find(By location) {
        return getDriver().findElement(location);
    }

    public List<WebElement> findAll(By location) {
        return getDriver().findElements(location);
    }

    public void click(By location) {
        find(location).click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(By location, String text) {
        find(location).sendKeys(text);

    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }


    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void changeTab(int tabIndex) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowHandles.get(tabIndex));
    }


}
