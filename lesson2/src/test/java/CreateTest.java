import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateTest extends TestBase {
    @Test
    public void upload() {
        CreatePage createPage = new CreatePage();
        createPage.open();
        createPage.uploadphoto();
    }
}
