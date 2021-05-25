package DriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/razmkhitaryan/Downloads/chromedriver");

        if (driver == null) {
            driver = new ChromeDriver();

        }
        return driver;
    }
}
