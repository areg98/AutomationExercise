import static Utils.CustomWebDriver.getDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Constants.Messages;
import Constants.Urls;
import Pages.ContactUs;

public class ContactUsTest extends BaseTest{

    ContactUs contactUs;

    @BeforeMethod
    public void init(){
        contactUs = new ContactUs(getDriver());
        contactUs.open();
    }

    @Test
    public void ContactUsForm(){
        Assert.assertTrue(contactUs.checkContactUsFormVisibility());
        contactUs.sendMessage();
        Assert.assertEquals(contactUs.getSuccessMessageText(), Messages.getContactUsSuccessMessage());
        contactUs.clickOnHomeButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), Urls.BASE_URL);
    }
}
