import static Utils.CustomWebDriver.getDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.TestCasesPage;

public class TestCasesTest extends BaseTest{

    TestCasesPage testCasesPage;
    @BeforeMethod
    public void init(){
        testCasesPage = new TestCasesPage(getDriver());
        testCasesPage.open();
    }

    /** Test Case 7 **/
    @Test
    public void checkTestCasesPage(){
        Assert.assertTrue(testCasesPage.checkTestCasesContainerVisibility());
    }

}
