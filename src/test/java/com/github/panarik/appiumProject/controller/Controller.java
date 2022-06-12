package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.model.base.MobileItem;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;

/**
 * Controller class contains all methods with Android driver. Screens use Controller methods.
 */
import static com.github.panarik.appiumProject.controller.AppiumInstance.controller;

public class Controller {

    public static final Logger log = LogManager.getLogger(); // logger

    protected MobileElement getElement(MobileItem mobileItem) {

        return (MobileElement) controller.get().driver.findElement(By.xpath(mobileItem.getLocatorBody()));
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

    protected void failAfterWaiting(MobileItem mobileitem) {
        Assert.fail("Element " + mobileitem.getName() + " hasn't found.");
    }

    /**
     * Set GEO.
     *
     * @param latitude
     * @param longitude
     */
    protected void setGeo(double latitude, double longitude) {
        controller.get().driver.setLocation(new Location(latitude, longitude, 10));
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
     * Allow permission on system window tish GEO permissions.
     */
    protected void getPermissionsGEO() {
        try {
            controller.get().driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
            //ToDo: for different devices needs different locators.
        } catch (NoSuchElementException e) {
            Assert.fail("'permissioncontroller allow' button not found.");
        }
    }

    /**
     * Verify {@link MobileItem} present on screen.
     *
     * @param item
     */
    protected void verifyItem(MobileItem item) {
        try {
            controller.get().driver.findElement(item.getLocatorType(), item.getLocatorBody());
        } catch (NoSuchElementException e) {
            Assert.fail("Can't find item '" + item.getName() + "' with locator '" + item.getLocatorBody() + "'.");
        }
    }

}
