package Pages;

import static Constants.Urls.*;
import static Utils.CustomWebDriver.getDriver;
import static Utils.WaitHelper.waitUntilElementAppeared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpLogin extends BasePage {
    private WebDriver driver;

    @FindBy(css = "button[data-qa = \"signup-button\"]")
    private WebElement signupButton;
    @FindBy(className = "fa-lock")
    private WebElement login;
    @FindBy(className = "signup-form")
    private WebElement signupForm;
    @FindBy(css = "input[data-qa=\"signup-name\"")
    private WebElement signupName;
    @FindBy(css = "input[data-qa=\"signup-email\"]")
    private WebElement signupEmail;
    @FindBy(className = "login-form")
    private WebElement loginForm;
    @FindBy(id = "id_gender1")
    private WebElement titleRadio;
    @FindBy(css = "input[data-qa=\"name\"]")
    private WebElement nameFiled;
    @FindBy(id  = "email")
    private WebElement emailFiled;
    @FindBy(css = "input[data-qa=\"password\"]")
    private WebElement passwordFiled;
    @FindBy(css = "select[data-qa=\"days\"]")
    private WebElement daysOption;

    @FindBy(css = "select[data-qa=\"months\"]")
    private WebElement monthsOption;
    @FindBy(css = "select[data-qa=\"years\"]")
    private WebElement yearsOption;

    @FindBy(id  = "newsletter")
    private WebElement newsletterCheckBox;
    @FindBy(id = "optin")
    private WebElement optinCheckBox;
    @FindBy(css = "input[data-qa=\"first_name\"]")
    private WebElement firstnameFiled;
    @FindBy(css = "input[data-qa=\"last_name\"]")
    private WebElement lastnameFiled;
    @FindBy(css = "input[data-qa=\"company\"]")
    private WebElement companyFiled;
    @FindBy(css = "input[data-qa=\"address\"]")
    private WebElement addressFiled;
    @FindBy(css = "input[data-qa=\"address2\"]")
    private WebElement address2Filed;
    @FindBy(css = "select[data-qa=\"country\"]")
    private WebElement countryOption;
    @FindBy(css = "input[data-qa=\"state\"]")
    private WebElement stateFiled;
    @FindBy(css = "input[data-qa=\"city\"]")
    private WebElement cityFiled;
    @FindBy(css = "input[data-qa=\"zipcode\"]")
    private WebElement zipcodeFiled;
    @FindBy(css = "input[data-qa=\"mobile_number\"]")
    private WebElement mobileNumberFiled;
    @FindBy(css = "button[data-qa=\"create-account\"]")
    private WebElement createAccountButton;
    @FindBy(css = "h2[data-qa=\"account-created\"]")
    private WebElement accountCreatedText;
    @FindBy(css = "a[data-qa=\"continue-button\"]")
    private WebElement continueButton;
    @FindBy(className = "fa-user")
    private WebElement loggedInText;
    @FindBy(css = "a[href=\"/delete_account\"]")
    private WebElement deleteAccountButton;
    @FindBy(css = "h2[data-qa=\"account-deleted\"]")
    private WebElement accountDeletedText;

    public SignUpLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkSignUpFormVisibility(){
        return signupForm.isDisplayed()? true : false;
    }

    public boolean checkLoginFormVisibility(){
        return loginForm.isDisplayed()? true : false;
    }

    public boolean checkAccountCreatedTextVisibility(){
        return accountCreatedText.isDisplayed()? true : false;
    }

    public boolean checkAccountDeletedTextVisibility(){
        return accountDeletedText.isDisplayed()? true : false;
    }

    public boolean checkLoggedInTextVisibility(){
        return loggedInText.isDisplayed()? true : false;
    }

    public String getLoggedInText(){
        return loggedInText.getText();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void clickOnDeleteAccountButton(){
        deleteAccountButton.click();
    }

    public void reisterUser(){
        signupName.sendKeys("Anun");
        signupEmail.sendKeys("name@mail.ru");
        signupButton.click();
    }

    public void fillDetalis(){
        Select day = new Select(daysOption);
        Select month = new Select(monthsOption);
        Select years = new Select(yearsOption);
        Select country = new Select(countryOption);


        titleRadio.click();
        nameFiled.clear();
        nameFiled.sendKeys("name");
        passwordFiled.sendKeys("123456");
        day.selectByIndex(5);
        month.selectByIndex(3);
        years.selectByIndex(12);
        newsletterCheckBox.click();
        optinCheckBox.click();
        firstnameFiled.sendKeys("Arsen");
        lastnameFiled.sendKeys("Beno");
        companyFiled.sendKeys("Gexi Club");
        addressFiled.sendKeys("Hovtashen");
        address2Filed.sendKeys("gexi glux");
        country.selectByVisibleText("Canada");
        stateFiled.sendKeys("Aragatsotn");
        cityFiled.sendKeys("Abaran");
        zipcodeFiled.sendKeys("0050");
        mobileNumberFiled.sendKeys("+37494568925");
        createAccountButton.click();
    }


    @Override
    protected void load() {
        driver.navigate().to(LOGIN_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        try{
            waitUntilElementAppeared(signupForm);
        }catch (Exception e){
            throw new Error();
        }

    }
}
