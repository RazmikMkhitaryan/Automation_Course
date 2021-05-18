import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static setup.DriverSetup.getDriver;

public class EditorPage extends BasePage {
    private By templates = By.cssSelector("[class*='customSizeContainer']");
    private By fitIcon = By.cssSelector("[class='sidebarTextIconWrap-0-2-176']");
    private By count = By.cssSelector("[class='customSizeItems-0-2-414']");


    @Override
    public String getUrl() {
        return null;
    }

//    public EditorPage() {
//        open(getUrl());
//    }
//
//    @Override
//    public String getUrl() {
//        return BASE_URL + "/create";
//    }



    public void clickOnFit() {
        click(fitIcon);

    }

    public int getCountOfFit() {
        WebElement templateIcons = new WebDriverWait(driver, 40)
                .until(ExpectedConditions.visibilityOfElementLocated((templates)));
        List<WebElement> all = findAll(templates);
        return all.size();

    }


}
