package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.controller.driver.Driver;
import com.github.panarik.appiumProject.model.base.Configs;
import com.github.panarik.appiumProject.model.base.Locator;
import com.github.panarik.appiumProject.model.base.MobileItem;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;

/**
 * Controller class contains all methods with Android driver. Screens use Controller methods.
 */
public class Controller {

    public static final Logger log = LogManager.getLogger(); // logger
    static ThreadLocal<Driver<AppiumDriver<MobileElement>>> controller = new ThreadLocal<>(); // Common driver.

    /**
     * Verify {@link MobileItem} present on screen.
     *
     * @param item
     */
    protected void verifyItem(MobileItem item) {
        try {
            controller.get().driver.findElement(item.getLocatorType(), item.getLocatorBody());
        } catch (NoSuchElementException e) {
            failAfterWaiting(item);
        }
    }

    /**
     * Getting current {@link MobileElement} from {@link MobileItem}.
     *
     * @param mobileItem item of {@link MobileItem}.
     * @return
     */
    protected MobileElement getElement(MobileItem mobileItem) {
        MobileElement element = null;
        try {
            element = controller.get().driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody());
        } catch (NoSuchElementException e) {
            failAfterWaiting(mobileItem);
        }
        return element;
    }

    /**
     * Click on element {@link MobileItem}
     *
     * @param mobileItem
     */
    protected void click(MobileItem mobileItem) {
        try {
            controller.get().driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody()).click();
        } catch (NoSuchElementException e) {
            failAfterWaiting(mobileItem);
        }
    }

    /**
     * Enter text into {@link MobileItem}
     *
     * @param mobileItem
     * @param text
     */
    protected void enterText(MobileItem mobileItem, String text) {
        try {
            controller.get().driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody()).sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail("Can't enter text on view '" + mobileItem.getName() + "'.");
        }
    }

    /**
     * Allow GEO permissions on system's window.
     */
    protected void getPermissionsGEO() {
        MobileItem item = new MobileItem("GEO Permission grant button",
                new Locator("com.android.permissioncontroller:id/permission_allow_foreground_only_button", ""));
        try {
            controller.get().driver.findElement(item.getLocatorType(), item.getLocatorBody()).click();
        } catch (NoSuchElementException e) {
            failAfterWaiting(item);
        }
    }

    /**
     * Set GEO for current device or emulator.
     *
     * @param latitude
     * @param longitude
     */
    protected void setGeo(double latitude, double longitude) {
        controller.get().driver.setLocation(new Location(latitude, longitude, 10));
    }

    private void failAfterWaiting(MobileItem mobileItem) {
        Assert.fail("Element '" + mobileItem.getName() + "' not found.\n" +
                "Waiting for: '" + Configs.GLOBAL_WAITING + "' seconds.\n" +
                "Screen: ''.\n" +
                "Locator type: '" + mobileItem.getLocatorType() + "'.\n" +
                "Locator body: '" + mobileItem.getLocatorBody() + "'");
    }

}
