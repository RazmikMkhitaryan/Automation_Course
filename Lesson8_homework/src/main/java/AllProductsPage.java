import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static setup.DriverSetup.getDriver;

public class AllProductsPage extends BasePage {
    private By allProductsInPageOne = By.cssSelector("[class='GridList__column___4RviC']");
    private By invitationTamplate = By.cssSelector("[data-test='invitation-templates']");
    private By nextPageButton = By.cssSelector("[data-test='page-next-arrow']");
    private By pagesNumber = By.cssSelector("[class ='Pagination__controlInput___2rZXA']");


    @Override
    public String getUrl() {
        return BASE_URL + "/photo-editing-tools";
    }

    public void openAllProducts() {
        open(getUrl());
    }

    public void scrollToElement() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", find(nextPageButton));

    }

    public boolean isElelemtVisible() {
        return isDisplayed(invitationTamplate);
    }

    public int allPageProducts() {
        List<WebElement> all = findAll(allProductsInPageOne);
        return all.size();
    }

    public int goToNextPage(int pageCount) {
        click(nextPageButton);
        return pageCount;

    }
    public void goToNextPage() {
        click(nextPageButton);


    }

    public int numberOfPage() {
        return Integer.parseInt(find(pagesNumber).getText());
    }

}
