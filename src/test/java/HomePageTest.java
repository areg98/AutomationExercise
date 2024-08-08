import static Utils.CustomWebDriver.getDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

import Constants.Messages;
import Pages.Footer;
import Pages.HomePage;

public class HomePageTest extends BaseTest{

    HomePage homePage;
    Footer footer;
    Messages messages;

    @BeforeMethod
    public void init(){
        homePage = new HomePage(getDriver());
        footer = new Footer(getDriver());
        messages = new Messages();
        homePage.open();
    }

    @Test
    public void subscribe(){
        Assert.assertTrue(footer.checkSubscribeFormVisibility());
        footer.subscribe();
        Assert.assertEquals(footer.getAlertSuccessText(), messages.getSUBSCRIBE_SUCCESS_ALERT());
    }
}
