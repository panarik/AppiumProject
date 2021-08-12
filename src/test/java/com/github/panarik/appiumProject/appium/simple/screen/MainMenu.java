package com.github.panarik.appiumProject.appium.simple.screen;

import com.github.panarik.appiumProject.appium.simple.util.SetupDevice;
import io.appium.java_client.MobileElement;

public class MainMenu {

    //Assert on Main screen
    public static MobileElement mainMenu = SetupDevice.appiumDriver.findElementById("com.github.panarik.smartFeatures:id/recyclerView");

}
