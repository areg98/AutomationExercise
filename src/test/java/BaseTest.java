import static Utils.CustomWebDriver.getDriver;
import static Utils.CustomWebDriver.setDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    @BeforeMethod
    public void beforeMethod(){
        setDriver();
    }

    @AfterMethod
    public void afterMethod() {
       getDriver().quit();
    }
}