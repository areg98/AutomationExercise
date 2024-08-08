package Pages;

import static Constants.Urls.CART_PAGE_URL;
import static Utils.CustomWebElement.getText;
import static Utils.WaitHelper.waitUntilElementAppeared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "breadcrumbs")
    private WebElement shoppingCartText;
    @FindBy(className = "cart_description")
    private List<WebElement> productNameList;
    @FindBy(className = "cart_price")
    private List<WebElement> productPriceList;

    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductName(int index){
        return getText(productNameList.get(index));
    }

    public String getProductPrice(int index){
        return getText(productPriceList.get(index));
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
