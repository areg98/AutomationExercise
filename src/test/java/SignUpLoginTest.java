import static Utils.CustomWebDriver.getDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Constants.Messages;
import Constants.Urls;
import Constants.UserData;
import Pages.CartPage;
import Pages.Header;
import Pages.Payment;
import Pages.ProductsPage;
import Pages.SignUpLoginPage;

public class SignUpLoginTest extends BaseTest {

    SignUpLoginPage signUpLogin;
    Header header;
    ProductsPage productsPage;
    CartPage cartPage;
    UserData userData;
    Messages messages;
    Payment payment;

    @BeforeMethod
    public void init() {
        signUpLogin = new SignUpLoginPage(getDriver());
        header = new Header(getDriver());
        productsPage = new ProductsPage(getDriver());
        cartPage = new CartPage(getDriver());
        userData = new UserData();
        messages = new Messages();
        payment = new Payment(getDriver());
        signUpLogin.open();
    }

    /** Test Case 1 **/
    @Test
    public void registerUser() {
        signUpLogin.registerUser("name", "name010@mail.com");
        Assert.assertTrue(signUpLogin.checkLoginFormVisibility());
        signUpLogin.fillDetalis();
        Assert.assertTrue(signUpLogin.checkAccountCreatedTextVisibility());
        signUpLogin.clickOnContinueButton();
        Assert.assertTrue(signUpLogin.checkLoggedInTextVisibility());
        signUpLogin.clickOnDeleteAccountButton();
        Assert.assertTrue(signUpLogin.checkAccountDeletedTextVisibility());
        signUpLogin.clickOnContinueButton();
    }

    /** Test Case 2 **/
    @Test
    public void LoginUserWithCorrectData() {
        Assert.assertTrue(signUpLogin.checkLoginFormVisibility());
        signUpLogin.login(userData.getEMAIL(), userData.getPASSWORD());
        Assert.assertTrue(signUpLogin.checkLoggedInTextVisibility());
        header.clickOnLogout();
        Assert.assertEquals(getDriver().getCurrentUrl(), Urls.LOGIN_URL);
    }

    /** Test Case 3 **/
    @Test
    public void LoginUserWithIncorrectData() {
        Assert.assertTrue(signUpLogin.checkLoginFormVisibility());
        signUpLogin.login("incorrectEmail@mail.com", "incorrectPassword");
        Assert.assertEquals(signUpLogin.getLoginErrorMessage(), messages.getINCORRECT_LOGIN_DATA_ERROR_MESSAGE());
    }

    /** Test Case 5 **/
    @Test
    public void registerUserWithExistingEmail() {
        Assert.assertTrue(signUpLogin.checkSignUpFormVisibility());
        signUpLogin.registerUser("test", "test@mail.com");
        Assert.assertEquals(signUpLogin.getRegisterErrorMessage(), messages.getEXITING_EMAIL_ERROR_MESSAGE());
    }

    /** Test Case 14 **/
    @Test
    public void placeOrderRegWhileCheckout() {
        header.clickOnHome();
        productsPage.addToCart(1);
        productsPage.clickOnViewCart();
        Assert.assertTrue(cartPage.shoppingCartTextVisibility());
        cartPage.clickOnCheckoutButton();
        cartPage.clickOnRegLoginButton();
        signUpLogin.registerUser("name", "name015@mail.com");
        signUpLogin.fillDetalis();
        signUpLogin.clickOnContinueButton();
        Assert.assertTrue(signUpLogin.checkLoggedInTextVisibility());
        header.clickOnCart();
        cartPage.clickOnProceedCheckoutButton();
        cartPage.enterTextInCommentTextbox("some comment");
        cartPage.clickOnPlaceOrderButton();
        payment.fillCardInfo();
        payment.clickOnPayButton();
        Assert.assertTrue(payment.checkOrderPlacedTextVisibility());
        signUpLogin.clickOnDeleteAccountButton();
        Assert.assertTrue(signUpLogin.checkAccountDeletedTextVisibility());
    }
}