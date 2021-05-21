import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EditorPage extends BasePage{
    public By exportButton = By.cssSelector("[id='download-button']");
    public By downloadButton = By.linkText("Download");
    public By download = By.cssSelector("[data-test='downloaded-button']");

    @Override
    public String Url() {
        return BASE_URL+"/create/editor";
    }

    public void clickOnDownload(){
        try{
            WeitHelper.getInstance().waitForVisibilityOfElement(exportButton);
            click(exportButton);
            WeitHelper.getInstance().waitForVisibilityOfElement(download);
            click(download);

        }catch (Exception e){
            WeitHelper.getInstance().waitForVisibilityOfElement(downloadButton);
            click(downloadButton);
            WeitHelper.getInstance().waitForVisibilityOfElement(download);
            click(download);
        }


    }




}
