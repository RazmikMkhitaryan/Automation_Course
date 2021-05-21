import org.openqa.selenium.By;

public class HomePage extends BasePage{
    @Override
    public String Url() {
        return BASE_URL;
    }

    private By createButton = By.cssSelector("[data-test='headerNavigation-navigationListItem-Create']");

    public void clickOnCreateButton(){
        WeitHelper.getInstance().waitForVisibilityOfElement(createButton);
        click(createButton);
    }

}
