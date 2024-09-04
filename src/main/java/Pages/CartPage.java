package Pages;

import static Constants.Urls.CART_PAGE_URL;
import static Utils.CustomWebElement.click;
import static Utils.CustomWebElement.getText;
import static Utils.CustomWebElement.sendKey;
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
    @FindBy(className = "cart_quantity")
    private WebElement productQuantity;
    @FindBy(className = "check_out")
    private WebElement checkoutButton;
    @FindBy(xpath = "//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")
    private WebElement regLoginButton;
    @FindBy(xpath = "//*[@id=\"do_action\"]/div[1]/div/div/a")
    private WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea")
    private WebElement orderCommentTextBox;
    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
    private WebElement placeOrderButton;

    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterTextInCommentTextbox(String text){
        sendKey(orderCommentTextBox, text);
    }

    public boolean shoppingCartTextVisibility(){
        return shoppingCartText.isDisplayed();
    }

    public String getProductName(int index){
        return getText(productNameList.get(index));
    }

    public String getProductPrice(int index){
        return getText(productPriceList.get(index));
    }

    public String getProductQuantity(){
        return getText(productQuantity);
    }

    public void clickOnCheckoutButton(){
        click(checkoutButton);
    }

    public void clickOnRegLoginButton(){
        click(regLoginButton);
    }

    public void clickOnProceedCheckoutButton(){
        click(proceedToCheckoutButton);
    }

    public void clickOnPlaceOrderButton(){
        click(placeOrderButton);
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
