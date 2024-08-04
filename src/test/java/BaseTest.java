import static Utils.CustomWebDriver.getDriver;
import static Utils.CustomWebDriver.setDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Objects;

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