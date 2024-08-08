import static Utils.CustomWebDriver.getDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Constants.Messages;
import Constants.Urls;
import Constants.UserData;
import Pages.Header;
import Pages.SignUpLoginPage;

public class SignUpLoginTest extends BaseTest {

    SignUpLoginPage signUpLogin;
    Header header;
    UserData userData;
    Messages messages;

    @BeforeMethod
    public void init() {
        signUpLogin = new SignUpLoginPage(getDriver());
        header = new Header(getDriver());
        userData = new UserData();
        messages = new Messages();
        signUpLogin.open();
    }

    @Test
    public void registerUser() {
        signUpLogin.registerUser("name", "name@mail.com");
        Assert.assertTrue(signUpLogin.checkLoginFormVisibility());
        signUpLogin.fillDetalis();
        Assert.assertTrue(signUpLogin.checkAccountCreatedTextVisibility());
        signUpLogin.clickOnContinueButton();
        Assert.assertTrue(signUpLogin.checkLoggedInTextVisibility());
        signUpLogin.clickOnDeleteAccountButton();
        Assert.assertTrue(signUpLogin.checkAccountDeletedTextVisibility());
        signUpLogin.clickOnContinueButton();
    }

    @Test
    public void  registerUserWithExistingEmail() {
        Assert.assertTrue(signUpLogin.checkSignUpFormVisibility());
        signUpLogin.registerUser("test", "test@mail.com");
        Assert.assertEquals(signUpLogin.getRegisterErrorMessage(), messages.getEXITING_EMAIL_ERROR_MESSAGE());
    }


    @Test
    public void LoginUserWithCorrectData(){
        Assert.assertTrue(signUpLogin.checkLoginFormVisibility());

        signUpLogin.login(userData.getEMAIL(), userData.getPASSWORD());
        Assert.assertTrue(signUpLogin.checkLoggedInTextVisibility());
        header.clickOnLogout();
        Assert.assertEquals(getDriver().getCurrentUrl(), Urls.LOGIN_URL);
    }

    @Test
    public void LoginUserWithIncorrectData(){
        Assert.assertTrue(signUpLogin.checkLoginFormVisibility());
        signUpLogin.login("incorrectEmail@mail.com", "incorrectPassword");
        Assert.assertEquals(signUpLogin.getLoginErrorMessage(), messages.getINCORRECT_LOGIN_DATA_ERROR_MESSAGE());
    }
}