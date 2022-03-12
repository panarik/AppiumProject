package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.model.base.MobileItem;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import static com.github.panarik.appiumProject.controller.AppiumController.getController;

public class IOSController {

    IOSDriver<MobileElement> iOSDriver;

    public IOSController() {
        this.iOSDriver = getController().getIOSDriver();
    }

    public MobileElement getElement(MobileItem mobileItem) {
        return iOSDriver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody());
    }

}
