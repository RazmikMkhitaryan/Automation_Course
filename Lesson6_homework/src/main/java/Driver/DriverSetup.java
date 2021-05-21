package Driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;

public class DriverSetup {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        String downloadFilepath = System.getProperty("user.dir") + File.separator + "src/main/resources/Downloads";
        ChromeOptions options = new ChromeOptions();
        HashMap<String, String> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadFilepath);
        options.setExperimentalOption("prefs", chromePrefs);
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "/Users/razmkhitaryan/Downloads/chromedriver");

            driver = new ChromeDriver(options);

        }
        return driver;
    }
}
