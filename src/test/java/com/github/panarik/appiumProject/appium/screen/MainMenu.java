package com.github.panarik.appiumProject.appium.screen;

import com.github.panarik.appiumProject.appium.util.SetupDevice;
import io.appium.java_client.MobileElement;

public class MainMenu {

    //Assert on Main screen
    public static MobileElement mainMenu = SetupDevice.appiumDriver.findElementById("com.github.panarik.smartFeatures:id/recyclerView");

}
