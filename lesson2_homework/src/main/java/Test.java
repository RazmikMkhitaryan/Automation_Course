import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * My Test is checking registration process
 * All created user's information (Email and password) are saved in "text.txt" file in Lesson2_Homework package
 */

public class Test {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        System.setProperty("WebDriver.chrome.driver", "chromedriver");
        driver.get("https:/picsart.com");
        driver.findElement(By.cssSelector("[data-test='headerAuth-signUpBtn pa-uiLib-headerAuth-authBtn']")).click();
        //wait for loading
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='email']")));

        //Checking that Create account button is a clickable

        try {
            //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signUp pa-uiLib-authentication-button-disabled']")));
            driver.findElement(By.cssSelector("[class='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signUp pa-uiLib-authentication-button-disabled']")).click();
            String text = driver.findElement(By.cssSelector("[class='root-0-2-96 pa-uiLib-authentication-controlStatus']")).getText();
            if (text == "Enter your email") {
                System.out.println("Create free account button is not clickable");
            }

        } catch (Exception e) {
            System.out.println("Create free account button is not clickable");
        }


        //Sign up
        try {
            driver.findElement(By.name("email")).sendKeys(TestService.emailGenerator(6));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            driver.findElement(By.name("password")).sendKeys(TestService.stringGenerator(6));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Trying to register a user
        try {
            driver.findElement(By.cssSelector("[class='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signUp']")).click();

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='image-0-2-591 default placeholder']")));
                System.out.println("Registration is successfully done");

            } catch (Exception e) {
                System.out.println("Registration Failed");
            }

        } catch (Exception e) {
            System.out.println("Incorrect Password");
        }
        //Go to batch screen
        driver.findElement(By.cssSelector("[data-test='headerNavigation-navigationListItem-Batch Editor']")).click();
        //Upload a photo

        try {
            WebElement element = driver.findElement(By.cssSelector("[accept='image/jpeg,image/png']"));
            String imagePath = System.getProperty("user.dir") + File.separator + "image.jpeg";
            element.sendKeys(imagePath);
        } catch (Exception e) {
            System.out.println("Uploading failed");
        }

        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='gridImage-0-2-64']")));
            System.out.println("Uploading is successfully done");
        } catch (Exception e) {
            System.out.println("Uploading failed");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("[class='toolContainer-0-2-52']:last-child")).click();
        // driver.findElement(By.cssSelector("[class='removeBgItem-0-2-141']]")).click();

//        driver.findElement(By.cssSelector("[class='removeBgContent-0-2-139']:nth-child(2)")).click();
//        WebElement element1 = driver.findElement(By.cssSelector("[accept='image/jpeg, image/png']"));
//        element1.sendKeys("/Users/razmkhitaryan/Desktop/photo-1554151228-14d9def656e4.jpeg");


    }
}

