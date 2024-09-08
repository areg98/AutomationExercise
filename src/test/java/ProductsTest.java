import static Utils.CustomWebDriver.getDriver;
import static Utils.CustomWebElement.printInfo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.CartPage;
import Pages.Header;
import Pages.ProductsPage;
import Pages.ProductsPage.ProductDetails;

public class ProductsTest extends BaseTest {

    ProductsPage productsPage;
    ProductDetails productDetails;
    CartPage cartPage;
    Header header;

    @BeforeMethod
    public void init() {
        productsPage = new ProductsPage(getDriver());
        cartPage = new CartPage(getDriver());
        productDetails = new ProductDetails();
        header = new Header(getDriver());
        productsPage.open();
    }

    /**
     * Test Case 8
     **/
    @Test
    public void checkProductDetails() {
        SoftAssert softAssert = new SoftAssert();
        productsPage.openProductDetails();
        softAssert.assertTrue(productDetails.checkProductNameVisibility());
        softAssert.assertTrue(productDetails.checkProductCategoryVisibility());
        softAssert.assertTrue(productDetails.checkProductPriceVisibility());
        softAssert.assertTrue(productDetails.checkProductAvailabilityVisibility());
        softAssert.assertTrue(productDetails.checkProductConditionVisibility());
        softAssert.assertTrue(productDetails.checkProductBrandVisibility());
        softAssert.assertAll();
    }

    /**
     * Test Case 9
     **/

    // Todo - use api for search and checking search result data
    @Test
    public void searchProduct() {
        productsPage.getAllProductsList();
//        productsPage.searchProduct("Premium Polo T-Shirts");
//        Assert.assertTrue(productsPage.checkSearchResultVisibility());
    }

    /**
     * Test Case 12
     **/
    @Test
    public void addProductsInCart() {
        String productPrice1 = productsPage.getProductPrice(0);
        String productPrice2 = productsPage.getProductPrice(1);
        String productName1 = productsPage.getProductName(0);
        String productName2 = productsPage.getProductName(1);
        productsPage.addToCart(1);
        productsPage.clickOnContinueShoppingButton();
        productsPage.addToCart(2);
        productsPage.clickOnViewCart();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cartPage.getProductName(0).contains(productName1));
        softAssert.assertTrue(cartPage.getProductName(1).contains(productName2));
        softAssert.assertEquals(cartPage.getProductPrice(0), productPrice1);
        softAssert.assertEquals(cartPage.getProductPrice(1), productPrice2);
        softAssert.assertAll();
    }

    /**
     * Test Case 13
     **/
    @Test
    public void verifyProductQuantity() {
        productsPage.openProductDetails();
        productDetails.setQuantity("4");
        productDetails.clickOnAddToCartButton();
        productsPage.clickOnViewCart();
        Assert.assertEquals(cartPage.getProductQuantity(), "4");

    }

}
