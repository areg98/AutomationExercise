import static Utils.CustomWebDriver.getDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Constants.Messages;
import Constants.Urls;
import Pages.ContactUsPage;

public class ContactUsTest extends BaseTest{

    ContactUsPage contactUs;
    Messages messages;

    @BeforeMethod
    public void init(){
        contactUs = new ContactUsPage(getDriver());
        messages = new Messages();
        contactUs.open();
    }

    /** Test Case 6 **/
    @Test
    public void ContactUsForm(){
        Assert.assertTrue(contactUs.checkContactUsFormVisibility());
        contactUs.sendMessage();
        Assert.assertEquals(contactUs.getSuccessMessageText(), messages.getCONTACT_US_SUCCESS_MESSAGE());
        contactUs.clickOnHomeButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), Urls.BASE_URL);
    }
}
