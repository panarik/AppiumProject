package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.controller.driver.Driver;
import com.github.panarik.appiumProject.model.base.Configs;
import com.github.panarik.appiumProject.model.base.tools.JsonParser;
import com.github.panarik.appiumProject.model.base.tools.data.TestData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.github.panarik.appiumProject.controller.Controller.controller;
import static com.github.panarik.appiumProject.controller.Controller.log;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class AppiumInstance {

    public void setup(String OS) {
        TestData config = new JsonParser().getData(); // get device settings
        DesiredCapabilities cap = new DesiredCapabilities();
        switch (OS) {
            case ("ANDROID"): {
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
                    controller.set(new Driver(new AndroidDriver<MobileElement>(url, cap)));
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            }

            case ("IOS"): {
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getIOS().get("platformVersion"));
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, config.getIOS().get("deviceName"));
                cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
                cap.setCapability(MobileCapabilityType.UDID, config.getIOS().get("udid"));
                cap.setCapability(MobileCapabilityType.APP, config.getIOS().get("app"));
                try {
                    URL url = new URL("http://127.0.0.1:4723/wd/hub");
                    controller.set(new Driver(new IOSDriver<MobileElement>(url, cap)));
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        log.info("Created " + OS + " session.");

        // Setup implicit waiter.
        controller.get().driver.manage().timeouts().implicitlyWait(Configs.GLOBAL_WAITING, TimeUnit.SECONDS);
    }

    public void stop() {
        if (controller.get().driver != null) {
            controller.get().driver.quit();
            log.trace("Driver has shutdown.");
        } else log.trace("Driver already shutdown.");
    }

}
