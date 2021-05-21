import org.openqa.selenium.By;

public class GetFreeAppDialog extends BasePage{
    private By qrCode = By.cssSelector(".qrcode");

    @Override
    public String getUrl() {
        return null;
    }

    public boolean isQrVisible() {
        return isDisplayed(qrCode);
    }


}

