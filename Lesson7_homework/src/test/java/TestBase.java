import org.testng.annotations.AfterMethod;

public class TestBase {
    @AfterMethod
    public void tearDown() {
      //   getDriver().quit();
    }
}
