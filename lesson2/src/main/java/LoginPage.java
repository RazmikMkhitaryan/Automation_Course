import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginPage {
    private WebDriver driver;
    private By usernameFieldLocation = By.name("username");
    private By passwordFieldLocation = By.name("password");
    private By loginButtonLocation = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private By signInButtonLocation = By.cssSelector("[class='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn']");
    private By avatarImageLocation = By.cssSelector("[class='root-0-2-589 pa-uiLib-headerProfileInfo-avatar']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocation);
        loginButton.click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameFieldLocation));
    }

    public void typeUsername(String username) {
        WebElement usernameField = driver.findElement(usernameFieldLocation);
        usernameField.sendKeys(username);
    }

    public void typePassword(String password) {
        WebElement passwordField = driver.findElement(passwordFieldLocation);
        passwordField.sendKeys(password);
    }


    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(signInButtonLocation);
        signInButton.click();

    }

    public boolean isAvatarDisplayed() {
        WebElement avatarIcon = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated((avatarImageLocation)));
        return driver.findElement(avatarImageLocation).isDisplayed();

    }

    public boolean isUserLoggedIn() {
        WebElement avatarIcon = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated((avatarImageLocation)));
        return avatarIcon.isDisplayed();
    }

}
