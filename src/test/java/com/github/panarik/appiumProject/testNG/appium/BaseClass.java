package com.github.panarik.appiumProject.testNG.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {

    private static AppiumDriver<MobileElement> appium;

    @BeforeTest
    public void setup() {
        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID"); //аналог
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.VERSION, "11");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 9");
        cap.setCapability(MobileCapabilityType.UDID, "83209d47");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60); //через 60 сек отключаем девайс
        cap.setCapability("appActivity", "com.github.panarik.smartFeatures.activity.SignInActivity"); //через 60 сек отключаем девайс
        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appium = new AppiumDriver<>(url, cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simpleTest1() {
        System.out.println("Test1");
        Assert.assertTrue(true);
    }

    @AfterTest
    public void shutdown() {
    }


}
