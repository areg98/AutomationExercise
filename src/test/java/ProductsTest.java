import static Utils.CustomWebDriver.getDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.ProductsPage;
import Pages.ProductsPage.ProductDetails;

public class ProductsTest extends BaseTest{

    ProductsPage productsPage;
    ProductDetails productDetails;

    @BeforeMethod
    public void init(){
        productsPage = new ProductsPage(getDriver());
        productDetails = new ProductDetails();
        productsPage.open();
    }

    @Test
    public void check(){
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
}
