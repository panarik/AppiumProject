package com.github.panarik.appiumProject;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MainTest {

    static AppiumDriver<MobileElement> appiumDriver;

    public static void main(String[] args) {

        try {
            openApp();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static void openApp() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        //Redmi 4X
        cap.setCapability("deviceName", "Redmi Note 4X"); //имя девайса
        cap.setCapability("udid", "AQ9DHIIJGM7D7DOR"); // udid девайса
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "6.0");
        //about app
        cap.setCapability("appPackage", "com.github.panarik.smartFeatures");
        cap.setCapability("appActivity", "com.github.panarik.smartFeatures.activity.SignInActivity");

        //send cap on Appium server
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        appiumDriver = new AppiumDriver<MobileElement>(url, cap);
        System.out.println("app started...");

    }

}
