import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class TheFirstTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/razmkhitaryan/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //driver.get("https://picsartstage2.com");
        driver.get("https://picsart.com");



        WebElement loginButton = driver.findElement(By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']"));
        loginButton.click();
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("username")));

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("replayeditor");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("123456");

        WebElement signInButton = driver.findElement(By.cssSelector("[class='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn']"));
        signInButton.click();

        //driver.quit();
    }
}
