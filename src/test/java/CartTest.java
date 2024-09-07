import static Utils.CustomWebDriver.getDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Constants.Messages;
import Pages.CartPage;
import Pages.Footer;

public class CartTest extends BaseTest {

    CartPage cartPage;
    Footer footer;
    Messages messages;

    @BeforeMethod
    public void init() {
        cartPage = new CartPage(getDriver());
        footer = new Footer(getDriver());
        messages = new Messages();
        cartPage.open();
    }

    /** Test Case 11 **/
    @Test
    public void subscribe(){
        Assert.assertTrue(footer.checkSubscribeFormVisibility());
        footer.subscribe();
        Assert.assertEquals(footer.getAlertSuccessText(), messages.getSUBSCRIBE_SUCCESS_ALERT());
    }
}
