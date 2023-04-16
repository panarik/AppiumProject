package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.model.elements.MobileItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Appium controller class contains all common methods for Android and iOS. Screens can't use Appium controller methods directly.
 */
public abstract class WebController {

    public static final Logger log = LogManager.getLogger(); // logger
    private final WebDriver driver;

    protected WebController(WebDriver appiumDriver) {
        driver = appiumDriver;
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
