package Pages;

import static Constants.Urls.CONTACT_US_URL;
import static Constants.Urls.PRODUCTS_PAGE_URL;
import static Utils.CustomWebDriver.getDriver;
import static Utils.CustomWebElement.*;
import static Utils.WaitHelper.waitUntilElementAppeared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constants.UserData;

public class ContactUsPage extends BasePage {

    UserData userData;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        userData = new UserData();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "contact-form")
    private WebElement contactUsForm;
    @FindBy(css = "input[data-qa=\"name\"]")
    private WebElement nameFiled;
    @FindBy(css = "input[data-qa=\"email\"]")
    private WebElement emailFiled;
    @FindBy(css = "input[data-qa=\"subject\"]")
    private WebElement subjectFiled;
    @FindBy(css = "input[data-qa=\"message\"]")
    private WebElement messageFiled;
    @FindBy(css = "input[data-qa=\"submit-button\"]")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")
    private WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"form-section\"]/a")
    private WebElement homeButton;


    public boolean checkContactUsFormVisibility() {
        return contactUsForm.isDisplayed();
    }

    public void sendMessage() {
        sendKey(nameFiled, userData.getNAME());
        sendKey(emailFiled, userData.getEMAIL());
        sendKey(subjectFiled, "something");
        sendKey(messageFiled, "some message");
        click(submitButton);
        getDriver().switchTo().alert().accept();
    }

    public void clickOnHomeButton() {
        click(homeButton);
    }

    public String getSuccessMessageText() {
        return getText(successMessage);
    }


    @Override
    protected String getUrl() {
        return CONTACT_US_URL;
    }


    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        try {
            waitUntilElementAppeared(contactUsForm);
        } catch (Exception e) {
            throw new Error();
        }

    }
}
