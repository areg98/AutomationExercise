package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWebDriver {

    static WebDriver driver;

    public static void setDriver() {
//        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hovak\\IdeaProjects\\AutomationExercise\\chromedriver.exe");
//        driver = new ChromeDriver(chromeOptions);

    }

    public static WebDriver getDriver(){
        return driver;
    }
}
