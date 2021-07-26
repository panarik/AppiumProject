package com.github.panarik.appiumProject;

import com.github.panarik.appiumProject.util.SetupDevice;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

public class MainTest {
    static AppiumDriver<MobileElement> appiumDriver;

    public static void main(String[] args) {
        appiumDriver = SetupDevice.redmi4X(); //сетапим девайс
        goToMainScenario(); //сценарий онбординга
    }

    public static void goToMainScenario() {
        //Actions on singIn screen
        MobileElement enter = appiumDriver.findElementById("com.github.panarik.smartFeatures:id/sign_in_without_auth");
        enter.click();

        //Assert on Main screen
        MobileElement mainMenu = appiumDriver.findElementById("com.github.panarik.smartFeatures:id/recyclerView");
        Assert.assertTrue(mainMenu.isDisplayed());
    }

}
