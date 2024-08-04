import static Utils.CustomWebDriver.getDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.SignUpLogin;

public class signUpLogin extends BaseTest {

    SignUpLogin signUpLogin;

    @BeforeMethod
    public void init() {
        signUpLogin = new SignUpLogin(getDriver());
        signUpLogin.open();
    }

    @Test
    public void test() {
        Assert.assertTrue(signUpLogin.checkSignUpFormVisibility());
        signUpLogin.reisterUser();
        Assert.assertTrue(signUpLogin.checkLoginFormVisibility());
        signUpLogin.fillDetalis();
        Assert.assertTrue(signUpLogin.checkAccountCreatedTextVisibility());
        signUpLogin.clickOnContinueButton();
        Assert.assertTrue(signUpLogin.checkLoggedInTextVisibility());
        signUpLogin.clickOnDeleteAccountButton();
        Assert.assertTrue(signUpLogin.checkAccountDeletedTextVisibility());
        signUpLogin.clickOnContinueButton();


    }
}