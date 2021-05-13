import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;

public class LoginPage {
    private WebDriver driver;
    private By usernameFieldLocation = By.name("username");
    private By passwordFieldLocation = By.name("password");
    private By loginButtonLocation = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private By signInButtonLocation = By.cssSelector("[class='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn']");
    private By avatarImageLocation = By.cssSelector("[class='root-0-2-589 pa-uiLib-headerProfileInfo-avatar']");
    private By signInButtonDisableLocation = By.cssSelector("[class='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn pa-uiLib-authentication-button-disabled']");
    private By incorrectUsernameOrPassword = By.cssSelector("[class='root-0-2-83 error-0-2-84']");
    private By accountIcon = By.cssSelector("[class='image-0-2-591 default placeholder']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() throws InterruptedException {
        Thread.sleep(1500);
        WebElement loginButton = driver.findElement(loginButtonLocation);
        loginButton.click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameFieldLocation));
    }

    public void typeUsername(String username) {
        WebElement usernameField = driver.findElement(usernameFieldLocation);
        usernameField.sendKeys(username);
    }

    public void clearPassword() {
        WebElement passwordField = driver.findElement(passwordFieldLocation);
        passwordField.sendKeys(Keys.COMMAND + Keys.chord("a") + Keys.DELETE);
    }

    public void clearUsername() {
        WebElement usernameField = driver.findElement(usernameFieldLocation);
        usernameField.sendKeys(Keys.COMMAND + Keys.chord("a") + Keys.DELETE);
    }

    public void typePassword(String password) {
        WebElement passwordField = driver.findElement(passwordFieldLocation);
        passwordField.sendKeys(password);
    }


    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(signInButtonLocation);
        signInButton.click();

    }


    public boolean isUserLoggedIn() {
        WebElement avatarIcon = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated((avatarImageLocation)));
        return avatarIcon.isDisplayed();
    }


    public boolean signInButtonIsClickable() {
        try {
            WebElement element = driver.findElement((signInButtonDisableLocation));
            String aClass = element.getAttribute("class");
            if (aClass.contains("disable")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            WebElement element = driver.findElement((signInButtonLocation));
            String aClass = element.getAttribute("class");
            if (aClass.contains("disable")) {
                return false;
            }
            return true;
        }

    }

    public void incorrectUsernameOrPassword() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(incorrectUsernameOrPassword));
            System.out.println("Username or Password are incorrect!!!");

        } catch (Exception e) {
            System.out.println("Login successfully done");
        }

    }


    public void accountImage() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(accountIcon));
            System.out.println("Log in Doneeeeeee!!!");

        } catch (Exception e) {
            System.out.println("User not found gna parapi ");
        }
    }


}
