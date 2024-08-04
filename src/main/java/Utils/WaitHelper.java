package Utils;

import static Utils.CustomExpectedCondition.*;
import static Utils.CustomWebDriver.getDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private static final int TIME_OUT = 10;
    static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TIME_OUT));

    public static void waitUntilElementToBeClickable(WebElement element) {
        wait.until(toBeAppeared(element));
        wait.until(toBeClickable(element));
    }

    public static void waitUntilTextAppeared(WebElement element) {
        wait.until(textToBeDisplayed(element));
    }

    public static void waitUntilElementAppeared(WebElement element) {
//        wait.until(toBeAppeared(element));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilColorToBeAppeared(WebElement element){
        wait.until(toBeColorAppeared(element));
    }

}
