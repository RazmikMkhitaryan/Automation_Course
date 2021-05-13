import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class IncorrectLoginTest {
    private WebDriver driver;


    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/razmkhitaryan/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://picsart.com");
    }

    @AfterTest
    public void close() {
        driver.quit();
    }



    /**
     * My test is about login functionality , i tra all versions ro do log in
     * 1.no username no password
     * 2.yes username no password
     * 3.no username yes password
     * 4.yes username yes password incorrect
     * 5.yes username yes password valid
     */

    @Test
    public void IncorrectLoginOrPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        for (int i = 0; i <= 4; i++) {
            if (i == 0) {
                // loginPage.typeUsername("hfhgfhjgfhg");
                //loginPage.typePassword("sgdfhgsf");
                if (loginPage.signInButtonIsClickable()) {
                    System.out.println("button is clickable");
                    loginPage.clickSignInButton();
                } else {
                    System.out.println("Button is not clickable");
                }
            }

            if (i == 1) {
                // loginPage.typeUsername("");
                loginPage.typePassword("sgdfhgsf");
                if (loginPage.signInButtonIsClickable()) {
                    System.out.println("button is clickable");
                    loginPage.clickSignInButton();
                } else {
                    System.out.println("username is missing Button is not clickable");
                    loginPage.clearPassword();

                }
            }

            if (i == 2) {
                loginPage.typeUsername("hfhgfhjgfhg");
                // loginPage.typePassword("");
                if (loginPage.signInButtonIsClickable()) {
                    System.out.println("button is clickable");
                    loginPage.clickSignInButton();
                } else {
                    System.out.println("password is missing Button is not clickable");
                    loginPage.clearUsername();

                }
            }


            if (i == 3) {

                loginPage.typeUsername("hfhgfhjgfhg");
                loginPage.typePassword("sgdfhgsf");
                if (loginPage.signInButtonIsClickable()) {
                    loginPage.clickSignInButton();
                    loginPage.incorrectUsernameOrPassword();

                } else {
                    System.out.println("bot are missing Button is not clickable");
                }
            }

            if (i == 4) {
                loginPage.clearUsername();
                loginPage.clearPassword();
                loginPage.typeUsername("replayeditor");
                loginPage.typePassword("123456");
                if (loginPage.signInButtonIsClickable()) {
                    loginPage.clickSignInButton();
                    loginPage.accountImage();
                } else {
                    System.out.println("bot are missing Button is not clickable");
                }
            }


        }

    }

}

//}
