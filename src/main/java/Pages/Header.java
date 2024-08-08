package Pages;

import static Utils.CustomWebElement.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {


    public Header(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "fa-home")
    private WebElement home;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
    private WebElement products;
    @FindBy(className = "fa-shopping-cart")
    private WebElement shoppingCart;
    @FindBy(className = "fa-lock")
    private WebElement signupLogin;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a/i")
    private WebElement testCases;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[6]/a/i")
    private WebElement apiTesting;
    @FindBy(className = "fa-youtube-play")
    private WebElement videoTutorials;
    @FindBy(className = "fa-envelope")
    private WebElement contactUs;
    @FindBy(className = "fa-lock")
    private WebElement logoutButton;

    public void clickOnHome(){
        click(home);
    }

    public void clickOnProducts(){
        click(products);
    }

    public void clickOnCart(){
        click(shoppingCart);
    }

    public void clickOnSignupLogin(){
        click(signupLogin);
    }

    public void clickOnLogout(){
        click(logoutButton);
    }

    public void clickOnTestCases(){
        click(testCases);
    }

    public void clickOnApiTesting(){
        click(apiTesting);
    }

    public void clickOnVideoTutorials(){
        click(videoTutorials);
    }

    public void clickOnContactUs(){
        click(contactUs);
    }
}
