import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static Driver.DriverSetup.getDriver;

public class TestBase {
    @BeforeMethod
    public void setup() {
        //     getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void driverClose() {
        // getDriver().quit();
    }
}


