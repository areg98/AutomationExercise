package Utils;

import static Utils.CustomWebDriver.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomExpectedCondition {

    public static ExpectedCondition toBeAppeared(WebElement element) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return (element != null && element.isDisplayed());
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> textToBeDisplayed(WebElement element) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return !element.getText().isEmpty() && element.isDisplayed();
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> toBeClickable(WebElement element) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return element != null && element.isEnabled();
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> toBeColorAppeared(WebElement element) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    String script = "return window.getComputedStyle(document.querySelector('.password-strength-meter'),'::before').getPropertyValue('background-color')";
                    JavascriptExecutor js = (JavascriptExecutor) getDriver();
                    String backgroundColor = js.executeScript(script).toString();
                    backgroundColor = Color.fromString(backgroundColor).asHex();
                    return !backgroundColor.equals("#000000");
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }
}
