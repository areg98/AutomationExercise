package Pages;

import static Constants.Urls.PRODUCTS_PAGE_URL;
import static Constants.Urls.TEST_CASES_PAGE_URL;
import static Utils.WaitHelper.waitUntilElementAppeared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage extends BasePage {


    public TestCasesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "container")
    private WebElement testCasesContainer;

    public boolean checkTestCasesContainerVisibility() {
        return testCasesContainer.isDisplayed();
    }

    @Override
    protected String getUrl() {
        return TEST_CASES_PAGE_URL;
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        try {
            waitUntilElementAppeared(testCasesContainer);
        } catch (Exception e) {
            throw new Error();
        }
    }
}
