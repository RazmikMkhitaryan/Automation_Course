import org.openqa.selenium.By;

public class CreatePage extends BasePage{
    private By uploadButton = By.cssSelector("[accept='image/jpeg, image/png, image/gif']");
    @Override
    public String getUrl() {
        return BASE_URL + "/create";
    }

    public void open(){
        open(getUrl());
    }

    public void uploadphoto(){
        type(uploadButton,"/Users/razmkhitaryan/Desktop/lessons/image.png");
    }

}
