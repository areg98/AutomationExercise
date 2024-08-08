package Pages;

import static Constants.Urls.CART_PAGE_URL;
import static Utils.WaitHelper.waitUntilElementAppeared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(className = "breadcrumbs")
    private WebElement shoppingCartText;

    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }



    @Override
    protected String getUrl() {
        return CART_PAGE_URL;
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        try {
            waitUntilElementAppeared(shoppingCartText);
        } catch (Exception e) {
            throw new Error();
        }
    }
}
