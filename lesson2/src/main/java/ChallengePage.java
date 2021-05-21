import org.openqa.selenium.By;

public class ChallengePage extends BasePage {
    private By participateButtonLocation = By.cssSelector(".c-get-the-app-popup.primary-big-btn");
    @Override
    public String getUrl() {
        return BASE_URL + "/challenge";
    }

    public ChallengePage(){

    }
    public ChallengePage(String id) {
        open(getUrl() + "/" + id);

    }

    public void clickParticipate() {
        WaitHelper.getInstance().waitForElementDisplay(participateButtonLocation);
        find(participateButtonLocation).click();
    }

}



