package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.controller.driver.Driver;
import com.github.panarik.appiumProject.model.base.Configs;
import com.github.panarik.appiumProject.tools.JsonParser;
import com.github.panarik.appiumProject.tools.data.TestData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AppiumInstance {

    static ThreadLocal<Driver> controller = new ThreadLocal<>(); // Common driver.

    public void setup(String OS) {
        TestData config = new JsonParser().getData(); // get device settings
        switch (OS) {
            case ("ANDROID"): {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                cap.setCapability(MobileCapabilityType.VERSION, config.getAndroid().get("version"));
                cap.setCapability(MobileCapabilityType.UDID, config.getAndroid().get("udid"));
                cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
                cap.setCapability("appActivity", config.getAndroid().get("appActivity"));
                cap.setCapability("appPackage", config.getAndroid().get("appPackage"));
                cap.setCapability("unlockType", config.getAndroid().get("unlockType"));
                cap.setCapability("unlockKey", config.getAndroid().get("unlockKey"));
                try {
                    URL url = new URL("http://127.0.0.1:4723/wd/hub");
                    controller.set(new Driver(new AppiumDriver<MobileElement>(url, cap)));
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
