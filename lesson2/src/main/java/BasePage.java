import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static setup.DriverSetup.getDriver;

public abstract class BasePage {
    protected WebDriver driver;
    public static final String BASE_URL = "https://picsartstage2.com";

    public BasePage() {
        this.driver = getDriver();
    }

    public abstract String getUrl();

    public void open(String url){
        System.out.println("OPening url->" + url);
        driver.get(url);
    }

    public WebElement find(By location) {
        System.out.println("Finding  element->" + location.toString());

        return driver.findElement(location);
    }

    public void type(By location, String text) {
        System.out.println("Typing element->" + text);

        find(location).sendKeys(text);
    }

    public void type(WebElement element, String text) {
        System.out.println("Typing element->" + text);
        element.sendKeys(text);
    }

    public void click(By location) {
        System.out.println("clicking on element"+location.toString());
        click(find(location));
    }

    public void click(WebElement element) {
        element.click();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return  element.isDisplayed();
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


}
