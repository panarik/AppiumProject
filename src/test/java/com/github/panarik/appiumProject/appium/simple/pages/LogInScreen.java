package com.github.panarik.appiumProject.appium.simple.pages;

import com.github.panarik.appiumProject.appium.simple.util.SetupDevice;
import io.appium.java_client.MobileElement;

public class LogInScreen extends MobileElement {

    //Actions on singIn screen
    public static MobileElement enter = SetupDevice.driver.findElementById("com.github.panarik.smartFeatures:id/sign_in_without_auth");

    public static void onboardingScenario() {
        enter.click();
    }
}
