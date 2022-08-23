package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.controller.driver.Driver;
import com.github.panarik.appiumProject.model.base.Configs;
import com.github.panarik.appiumProject.model.base.Locator;
import com.github.panarik.appiumProject.model.base.MobileItem;
import com.github.panarik.appiumProject.model.screen.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;

import java.lang.reflect.Field;

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
    protected void verifyItem(MobileItem item, BaseScreen screen) {

        try {
            controller.get().driver.findElement(item.getLocatorType(), item.getLocatorBody());
        } catch (NoSuchElementException e) {
            failAfterWaiting(item, getScreenName(screen));
        }
    }

    /**
     * Getting current {@link MobileElement} from {@link MobileItem}.
     *
     * @param mobileItem item of {@link MobileItem}.
     * @return
     */
    protected MobileElement getElement(MobileItem mobileItem, BaseScreen screen) {
        MobileElement element = null;
        try {
            element = controller.get().driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody());
        } catch (NoSuchElementException e) {
            failAfterWaiting(mobileItem, getScreenName(screen));
        }
        return element;
    }

    /**
     * Click on element {@link MobileItem}
     *
     * @param mobileItem
     */
    protected void click(MobileItem mobileItem, BaseScreen screen) {
        try {
            controller.get().driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody()).click();
        } catch (NoSuchElementException e) {
            failAfterWaiting(mobileItem, getScreenName(screen));
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
            failAfterWaiting(item, "System window");
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

    private void failAfterWaiting(MobileItem mobileItem, String screenName) {
        Assert.fail("Element '" + mobileItem.getName() + "' not found.\n" +
                "Waiting for:  '" + Configs.GLOBAL_WAITING + "' seconds.\n" +
                "Screen name:  '" + screenName + "'.\n" +
                "Locator type: '" + mobileItem.getLocatorType() + "'.\n" +
                "Locator body: '" + mobileItem.getLocatorBody() + "'");
    }

    private String getScreenName(BaseScreen screen) {
        String fieldName = "SCREEN_NAME";
        String fieldValue = "";
        try {
            Field field = screen.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            fieldValue = field.get(screen).toString();
        } catch (NoSuchFieldException e) {
            throw new NoSuchElementException("Can't find field '" + fieldName + "' in screen '" + screen.getClass() + "'\n Be sure if it field exist.");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fieldValue;
    }

}
