package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static setup.DriverSetup.getDriver;

public class GoldPage extends BasePage{
    @FindBy(css = "[class='c0232']")
    private WebElement carousel;

    public GoldPage() {
        open(getUrl());
        PageFactory.initElements(getDriver(),this);
    }

    public GoldPage init(){
        PageFactory.initElements(getDriver(),this);
        return this;
    }

    @Override
    public String getUrl() {
        return BASE_URL+"/gold";
    }

    public void swipeCarousel() {
        init();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", carousel);

        Actions action = new Actions(getDriver());

        action.moveToElement(carousel).pause(Duration.ofSeconds(2))
                .clickAndHold(carousel).pause(Duration.ofSeconds(2))
                .moveByOffset(-100, 20)
                .release().build();
    }

}
