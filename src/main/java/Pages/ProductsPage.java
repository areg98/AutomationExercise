package Pages;

import static Constants.Urls.BASE_URL;
import static Constants.Urls.PRODUCTS_PAGE_URL;
import static Utils.CustomWebDriver.getDriver;
import static Utils.CustomWebElement.click;
import static Utils.CustomWebElement.getText;
import static Utils.CustomWebElement.hover;
import static Utils.CustomWebElement.printError;
import static Utils.CustomWebElement.printInfo;
import static Utils.CustomWebElement.sendKey;
import static Utils.WaitHelper.waitUntilElementAppeared;
import static Utils.ApiSpecification.*;
import static io.restassured.RestAssured.given;

import com.google.gson.JsonObject;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

import Utils.ApiSpecification;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseOptionsImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.Products;
import pojo.Root;

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
    @FindBy(className = "col-sm-4")
    private List<WebElement> productsList;
    @FindBy(className = "productinfo")
    private List<WebElement> productInfoList;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a")
    private WebElement firstAddToCartButton;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a")
    private WebElement secondAddToCartButton;
    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
    private WebElement continueShoppingButton;
    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
    private WebElement viewCartButton;
    @FindBy(id = "search_product")
    private WebElement searchInput;
    @FindBy(id = "submit_search")
    private WebElement searchButton;
    @FindBy(xpath = "//div[@class = 'single-products']")
    private WebElement searchResult;
    @FindBy(id = "quantity")
    private static WebElement productQuantity;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
    private static WebElement addToCartButton;


    public void getAllProductsList() {

        List<Products> products = new ApiSpecification().get("api/productsList")
                .then()
                .extract().body().jsonPath().getList("data.products", Products.class);

        printInfo(products.get(0).id);


    }

    public void openProductDetails() {
        Random random = new Random();
        click(viewProductsList.get(random.nextInt(0, viewProductsList.size())));
    }

    public void addToCart(int index) {
        hover(getDriver(), productsList.get(index));
        switch (index) {
            case 1:
                click(firstAddToCartButton);
                break;
            case 2:
                click(secondAddToCartButton);
                break;
            default:
                printError("no such index");
                break;
        }
    }


    public String getProductPrice(int index) {
        return getText(productInfoList.get(index)).substring(0, 7);
    }

    public String getProductName(int index) {
        String productInfo = getText(productInfoList.get(index));
        return productInfo.substring(8, productInfo.length() - 11);
    }

    public void clickOnContinueShoppingButton() {
        click(continueShoppingButton);
    }


    public void clickOnViewCart() {
        click(viewCartButton);
    }

    public void searchProduct(String text) {
        sendKey(searchInput, text);
        click(searchButton);
    }

    public boolean checkSearchResultVisibility() {
        return searchResult.isDisplayed();
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

        public boolean checkProductPriceVisibility() {
            return productPrice.isDisplayed();
        }

        public boolean checkProductAvailabilityVisibility() {
            return productAvailability.isDisplayed();
        }

        public boolean checkProductConditionVisibility() {
            return productCondition.isDisplayed();
        }

        public boolean checkProductBrandVisibility() {
            return productBrand.isDisplayed();
        }

        public void setQuantity(String quantity) {
            sendKey(productQuantity, quantity);
        }

        public void clickOnAddToCartButton() {
            click(addToCartButton);
        }

    }


}
