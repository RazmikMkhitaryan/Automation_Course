import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 {
    public static void main(String[] args)  throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/razmkhitaryan/Downloads/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://picsart.com");
        driver.findElement(By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']")).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='username']")));
        driver.findElement(By.name("username")).sendKeys("xsjzjnXSJhgZJN43@gmail.com");
        driver.findElement(By.name("password")).sendKeys("vwkcnlVWKCNL10..");
        driver.findElement(By.cssSelector("[class='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn']")).click();


    }
}
