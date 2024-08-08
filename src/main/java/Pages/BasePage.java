package Pages;

import static Utils.JSWaiter.waitForJQueryToLoad;
import static Utils.JSWaiter.waitUntilJSReady;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;


public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    WebDriver driver;
    Header header;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);

    }

    protected abstract String getUrl();

    @Override
    protected void  load() {
        driver.get(getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        try {
            waitUntilJSReady();
            waitForJQueryToLoad();
        } catch (Exception e) {
            throw new Error();
        }
    }

    public LoadableComponent<T> open() {
        this.load();
        return get();
    }
}
