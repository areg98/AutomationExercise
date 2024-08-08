package Pages;

import static Utils.CustomWebElement.click;
import static Utils.CustomWebElement.getText;
import static Utils.CustomWebElement.sendKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constants.UserData;

public class Footer {

    UserData userData;

    public Footer(WebDriver driver){
        userData = new UserData();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "single-widget")
    private WebElement subscribeForm;
    @FindBy(id = "susbscribe_email")
    private WebElement subscribeInput;
    @FindBy(id = "subscribe")
    private WebElement subscribeButton;
    @FindBy(className = "alert-success")
    private WebElement alertSuccess;

    public void subscribe() {
        sendKey(subscribeInput, userData.getEMAIL());
        click(subscribeButton);
    }

    public boolean checkSubscribeFormVisibility() {
        return subscribeForm.isDisplayed();
    }

    public String getAlertSuccessText(){
        return getText(alertSuccess);
    }
}
