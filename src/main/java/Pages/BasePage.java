package Pages;

import static Utils.JSWaiter.waitForJQueryToLoad;
import static Utils.JSWaiter.waitUntilJSReady;

import Utils.LoadableComponent;

public class BasePage extends LoadableComponent<BasePage> {
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        try{
            waitUntilJSReady();
            waitForJQueryToLoad();
        }catch (Exception e){
            throw new Error();
        }
    }
}
