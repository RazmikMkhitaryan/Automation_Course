import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static setup.DriverSetup.getDriver;

public class LoginPage extends BasePage {
    private By usernameFieldLocation = By.name("username");
    private By passwordFieldLocation = By.name("password");
    private By loginButtonLocation = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private By signInButtonLocation = By.cssSelector("[class='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn']");
    private By avatarImageLocation = By.cssSelector("[class='root-0-2-589 pa-uiLib-headerProfileInfo-avatar']");

    public LoginPage() {
       driver.get("https://picsartstage2.com");

    }

    public void clickLoginButton() {
        click(find(loginButtonLocation));
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameFieldLocation));
    }

    public void typeUsername(String username) {
        type(usernameFieldLocation, username);
    }

    public void typePassword(String password) {
        type(passwordFieldLocation, password);
    }


    public void clickSignInButton() {
        click(signInButtonLocation);

    }

    public boolean isAvatarDisplayed() {
        WebElement avatarIcon = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated((avatarImageLocation)));
        return find(avatarImageLocation).isDisplayed();

    }

    public boolean isUserLoggedIn() {
        WebElement avatarIcon = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated((avatarImageLocation)));
        return avatarIcon.isDisplayed();
    }

    @Override
    public String getUrl() {
        return BASE_URL;
    }
}
