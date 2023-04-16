package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.model.elements.MobileItem;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.github.panarik.appiumProject.controller.AppiumInstance.log;

/**
 * Appium controller class contains all common methods for Android and iOS. Screens can't use Appium controller methods directly.
 */
public class WebController {

    private final WebDriver driver;

    public WebController() {
        WebDriver driver = AppiumInstance.DRIVER.get();
        if (driver instanceof RemoteWebDriver) {
            this.driver = driver;
            log.info("Web driver is ready.");
        } else this.driver = null;
    }

    /**
     * Verify {@link MobileItem} present on screen.
     *
     * @param item
     */
    public void verifyItem(MobileItem item) {
        try {
//            driver.findElement();
        } catch (NoSuchElementException e) {
//            failAfterWaiting(item);
        }
    }

    /**
     * Getting current element from {@link MobileItem}.
     *
     * @param mobileItem item of {@link MobileItem}.
     * @return
     */
    protected WebElement getElement(MobileItem mobileItem) {
        WebElement element = null;
        try {
//            element = driver.findElement();
        } catch (NoSuchElementException e) {
//            failAfterWaiting(mobileItem);
        }
        return element;
    }

    /**
     * Click on element {@link MobileItem}
     *
     * @param mobileItem
     */
    public void click(MobileItem mobileItem) {
        try {
//            driver.findElement().click();
        } catch (NoSuchElementException e) {
//            failAfterWaiting(mobileItem);
        }
    }

    /**
     * Enter text into {@link MobileItem}
     *
     * @param mobileItem
     * @param text
     */
    public void enterText(MobileItem mobileItem, String text) {
        try {
//            driver.findElement().sendKeys(text);
        } catch (NoSuchElementException e) {
//            Assert.fail("Can't enter text on view '" + mobileItem.getName() + "'.");
        }
    }

    /**
     * Allow GEO permissions on system's window.
     */
    public void getPermissionsGEO() {
        try {
//            driver.findElement().click();
        } catch (NoSuchElementException e) {
//            failAfterWaiting(item, "System window");
        }
    }

    private void failAfterWaiting(MobileItem mobileItem, String screenName) {
//        Assert.fail("Element '" + mobileItem.getName() + "' not found.\n" +
//                "Waiting for:  '" + Configs.GLOBAL_WAITING + "' seconds.\n" +
//                "Screen name:  '" + screenName + "'.\n" +
//                "Locator type: '" + mobileItem.getLocatorType() + "'.\n" +
//                "Locator body: '" + mobileItem.getLocatorBody() + "'");
    }

}
