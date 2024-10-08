package Pages;

import static Constants.Urls.BASE_URL;
import static Utils.CustomWebElement.*;
import static Utils.WaitHelper.waitUntilElementAppeared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constants.UserData;

public class HomePage extends BasePage {

    @FindBy(className = "carousel-inner")
    private WebElement adSlide;



    UserData userData;

    public HomePage(WebDriver driver) {
        super(driver);
        userData = new UserData();
        PageFactory.initElements(driver, this);
    }


    @Override
    protected String getUrl() {
        return BASE_URL;
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        try {
            waitUntilElementAppeared(adSlide);
        } catch (Exception e) {
            throw new Error();
        }
    }
}
