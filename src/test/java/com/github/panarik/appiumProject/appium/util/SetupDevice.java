package com.github.panarik.appiumProject.appium.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SetupDevice {

    public static AppiumDriver<MobileElement> appiumDriver;

    public static void redmi4X() {

        DesiredCapabilities cap = new DesiredCapabilities();
        //device
        cap.setCapability("deviceName", "Redmi Note 4X"); //имя девайса
        cap.setCapability("udid", "AQ9DHIIJGM7D7DOR"); // udid девайса
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "6.0");
        //app
        cap.setCapability("appPackage", "com.github.panarik.smartFeatures");
        cap.setCapability("appActivity", "com.github.panarik.smartFeatures.activity.SignInActivity");

        //send cap on Appium server
        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AppiumDriver<>(url, cap);
            System.out.println("app started.");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
