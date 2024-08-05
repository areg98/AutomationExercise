import static Utils.CustomWebDriver.getDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Constants.Messages;
import Constants.Urls;
import Constants.UserData;
import Pages.SignUpLogin;

public class SignUpLoginTest extends BaseTest {

    SignUpLogin signUpLogin;

    @BeforeMethod
    public void init() {
        signUpLogin = new Pages.SignUpLogin(getDriver());
        signUpLogin.open();
    }

    @Test
    public void registerUser() {
        Assert.assertTrue(signUpLogin.checkSignUpFormVisibility());
        signUpLogin.registerUser("name", "name@mail.ru");
        Assert.assertTrue(signUpLogin.checkSignUpFormVisibility());
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
        Assert.assertEquals(signUpLogin.getRegisterErrorMessage(), Messages.getExitingEmailErrorMessage());
    }


    @Test
    public void LoginUserWithCorrectData(){
        Assert.assertTrue(signUpLogin.checkLoginFormVisibility());
        signUpLogin.login(UserData.getEmail(), UserData.getPassword());
        Assert.assertTrue(signUpLogin.checkLoggedInTextVisibility());
        signUpLogin.logout();
        Assert.assertEquals(getDriver().getCurrentUrl(), Urls.LOGIN_URL);
    }

    @Test
    public void LoginUserWithIncorrectData(){
        Assert.assertTrue(signUpLogin.checkLoginFormVisibility());
        signUpLogin.login("incorrectEmail@mail.com", "incorrectPassword");
        Assert.assertEquals(signUpLogin.getLoginErrorMessage(), Messages.getIncorrectLoginDataErrorMessage());
    }
}