package Pages;

import static Utils.CustomWebElement.click;
import static Utils.CustomWebElement.sendKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Constants.UserData;

public class Payment {
    UserData userData;

    public Payment(WebDriver driver) {
        PageFactory.initElements(driver, this);
        userData = new UserData();
    }

    @FindBy(css = "[data-qa='name-on-card']")
    private WebElement nameOnCart;
    @FindBy(css = "[data-qa='card-number']")
    private WebElement cardNumber;
    @FindBy(css = "[data-qa='cvc']")
    private WebElement cardCVC;
    @FindBy(css = "[data-qa='expiry-month']")
    private WebElement cardExpiryMonth;
    @FindBy(css = "[data-qa='expiry-year']")
    private WebElement cardExpiryYear;
    @FindBy(css = "[data-qa='pay-button']")
    private WebElement payButton;
    @FindBy(css = "[data-qa='order-placed']")
    private WebElement orderPlaced;

    public void fillCardInfo() {
        sendKey(nameOnCart, userData.getCardName());
        sendKey(cardNumber, userData.getCardNumber());
        sendKey(cardCVC, userData.getCardCVC());
        sendKey(cardExpiryMonth, userData.getCardMonth());
        sendKey(cardExpiryYear, userData.getCardYear());
    }

    public void clickOnPayButton() {
        click(payButton);
    }

    public boolean checkOrderPlacedTextVisibility() {
        return orderPlaced.isDisplayed();
    }
}
