package Pages;

import static Constants.Urls.PRODUCTS_PAGE_URL;
import static Utils.CustomWebElement.click;
import static Utils.WaitHelper.waitUntilElementAppeared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {


    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "container")
    private WebElement productsContainer;
    @FindBy(className = "choose")
    List<WebElement> viewProductsList;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
    private static WebElement productName;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]")
    private static WebElement productCategory;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")
    private static WebElement productPrice;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]")
    private static WebElement productAvailability;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]")
    private static WebElement productCondition;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]")
    private static WebElement productBrand;

    public void openProductDetails() {
        Random random = new Random();
        click(viewProductsList.get(random.nextInt(0, viewProductsList.size())));
    }


    @Override
    protected String getUrl() {
        return PRODUCTS_PAGE_URL;
    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
        try {
            waitUntilElementAppeared(productsContainer);
        } catch (Exception e) {
            throw new Error();
        }
    }

    public static class ProductDetails {

        public boolean checkProductNameVisibility() {
            return productName.isDisplayed();
        }

        public boolean checkProductCategoryVisibility() {
            return productCategory.isDisplayed();
        }

        public boolean checkProductPriceVisibility(){
            return productPrice.isDisplayed();
        }

        public boolean checkProductAvailabilityVisibility(){
            return productAvailability.isDisplayed();
        }

        public boolean checkProductConditionVisibility(){
            return productCondition.isDisplayed();
        }

        public boolean checkProductBrandVisibility(){
            return productBrand.isDisplayed();
        }
    }
}
