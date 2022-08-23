package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.controller.driver.Driver;
import com.github.panarik.appiumProject.model.base.Configs;
import com.github.panarik.appiumProject.model.base.tools.JsonParser;
import com.github.panarik.appiumProject.model.base.tools.data.TestData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.github.panarik.appiumProject.controller.Controller.controller;
import static com.github.panarik.appiumProject.controller.Controller.log;


public class AppiumInstance {

    public void setup(String OS) {
        TestData config = new JsonParser().getData(); // get device settings
        DesiredCapabilities cap = new DesiredCapabilities();
        switch (OS) {
            case ("ANDROID") -> {
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                cap.setCapability(MobileCapabilityType.VERSION, config.getAndroid().get("version"));
                cap.setCapability(MobileCapabilityType.UDID, config.getAndroid().get("udid"));
                cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
                cap.setCapability(MobileCapabilityType.APP, config.getAndroid().get("app")); // for apps in repo.
//                cap.setCapability("appActivity", config.getAndroid().get("appActivity")); // for installed apps.
//                cap.setCapability("appPackage", config.getAndroid().get("appPackage")); // for installed apps.
                cap.setCapability("unlockType", config.getAndroid().get("unlockType"));
                cap.setCapability("unlockKey", config.getAndroid().get("unlockKey"));
                try {
                    URL url = new URL("http://127.0.0.1:4723/wd/hub");
                    controller.set(new Driver(new AndroidDriver<MobileElement>(url, cap)));
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            case ("Browserstack-Android") -> {

                // Set your access credentials
                cap.setCapability("browserstack.user", "your-browserstack-login");
                cap.setCapability("browserstack.key", "your-browserstack-key");

                // Set URL of the application under test
                cap.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

                // Specify device and os_version for testing
                cap.setCapability("device", "Google Pixel 3");
                cap.setCapability("os_version", "9.0");

                // Set other BrowserStack capabilities
                cap.setCapability("project", "First Java Project");
                cap.setCapability("build", "browserstack-build-1");
                cap.setCapability("name", "first_test");

                // Initialise the remote Webdriver using BrowserStack remote URL
                // and desired capabilities defined above
                AndroidDriver<AndroidElement> driver;
                try {
                    driver = new AndroidDriver<>(
                            new URL("http://hub.browserstack.com/wd/hub"), cap);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                controller.set(new Driver(driver));
            }
            case ("IOS") -> {
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
