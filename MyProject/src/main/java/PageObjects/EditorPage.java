package PageObjects;

import Helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class EditorPage extends BasePage {

    @FindBy(css = "[id='download-button']")
    private By exportButton;
    @FindBy(css = "[data-test='downloaded-button']")
    private By download;
    @FindBy(linkText = "Download")
    private By downloadButton;


    public EditorPage() {
        open(getUrl());
        PageFactory.initElements(getDriver(),this);

    }

    public EditorPage init(){
        PageFactory.initElements(getDriver(),this);

        return this;
    }

    @Override
    public String getUrl() {
        return BasePage.BASE_URL + "/create/editor";
    }

    public void clickOnDownload() {
        init();
        try {
           // Helpers.WaitHelper.getInstance().waitForElementDisplay(exportButton);
            click(exportButton);
          //  Helpers.WaitHelper.getInstance().waitForElementDisplay(download);
            init();
            click(download);

        } catch (Exception e) {
            init();
            WaitHelper.getInstance().waitForElementDisplay(downloadButton);
            click(downloadButton);
            WaitHelper.getInstance().waitForElementDisplay(download);
            init();
            click(download);
        }


    }


}
