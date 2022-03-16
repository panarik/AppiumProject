package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.controller.driver.Driver;
import com.github.panarik.appiumProject.model.base.Configs;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AppiumInstance {

    static ThreadLocal<Driver> controller = new ThreadLocal<>(); // Common driver.

    public void setup(String OS) {
        switch (OS) {
            case ("ANDROID"): {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                cap.setCapability(MobileCapabilityType.VERSION, "10");
//                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "DeviceName");
                cap.setCapability(MobileCapabilityType.UDID, "RZ8R92BWY4A");
                cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
                cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\user\\IdeaProjects\\AppiumProject\\src\\test\\resources\\app-SmartFeatures-debug.apk");
                cap.setCapability("unlockType", "pin");
                cap.setCapability("unlockKey", "1111");
                try {
                    URL url = new URL("http://127.0.0.1:4723/wd/hub");
                    controller.set(new Driver(new AndroidDriver<>(url, cap)));
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
                controller.get().driver.manage().timeouts().implicitlyWait(Configs.GLOBAL_WAITING, TimeUnit.SECONDS);

            }

            case ("IOS"): {
                //ToDo: Setup iOS.
            }
        }
    }

    public void stop() {
        if (controller.get().driver != null) {
            controller.get().driver.quit();
            System.out.println("Driver has shutdown.");
        }
    }

}
