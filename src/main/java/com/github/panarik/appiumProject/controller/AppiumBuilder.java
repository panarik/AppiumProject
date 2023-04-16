package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.tools.configs.JsonParser;
import com.github.panarik.appiumProject.tools.configs.data.TestData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.github.panarik.appiumProject.controller.WebController.log;


public class AppiumBuilder {

    static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>(); // Common driver.

    public void setup(String OS) {
        TestData config = new JsonParser().getData(); // get device settings
        DesiredCapabilities cap = new DesiredCapabilities();
        switch (OS) {
            case ("ANDROID") -> {
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
//                cap.setCapability(MobileCapabilityType.VERSION, config.getAndroid().get("version"));
//                cap.setCapability(MobileCapabilityType.UDID, config.getAndroid().get("udid"));
                cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
//                cap.setCapability(MobileCapabilityType.APP, config.getAndroid().get("app")); // for apps in repo.
//                cap.setCapability("appActivity", config.getAndroid().get("appActivity")); // for installed apps.
//                cap.setCapability("appPackage", config.getAndroid().get("appPackage")); // for installed apps.
//                cap.setCapability("unlockType", config.getAndroid().get("unlockType"));
//                cap.setCapability("unlockKey", config.getAndroid().get("unlockKey"));
                try {
                    URL url = new URL("http://127.0.0.1:4723/wd/hub");
                    DRIVER.set(new AndroidDriver(url, cap));
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
            }
//            case ("Browserstack-Android") -> {
//
//                // Set your access credentials
//                cap.setCapability("browserstack.user", "your-browserstack-login");
//                cap.setCapability("browserstack.key", "your-browserstack-key");
//
//                // Set URL of the application under test
//                cap.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
//
//                // Specify device and os_version for testing
//                cap.setCapability("device", "Google Pixel 3");
//                cap.setCapability("os_version", "9.0");
//
//                // Set other BrowserStack capabilities
//                cap.setCapability("project", "First Java Project");
//                cap.setCapability("build", "browserstack-build-1");
//                cap.setCapability("name", "first_test");
//
//                // Initialise the remote Webdriver using BrowserStack remote URL
//                // and desired capabilities defined above
//                try {
//                    URL url = new URL("http://hub.browserstack.com/wd/hub");
//                    INSTANCE.set(new Driver<>(new AndroidDriver<>(url, cap)));
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
            case ("IOS") -> {
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getIOS().get("platformVersion"));
//                cap.setCapability(MobileCapabilityType.DEVICE_NAME, config.getIOS().get("deviceName"));
                cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
//                cap.setCapability(MobileCapabilityType.UDID, config.getIOS().get("udid"));
//                cap.setCapability(MobileCapabilityType.APP, config.getIOS().get("app"));
                try {
                    URL url = new URL("http://127.0.0.1:4723/wd/hub");
                    DRIVER.set(new IOSDriver(url, cap));
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
        log.info("Created " + OS + " session.");

        // Setup implicit waiter.
        DRIVER.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void stop() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            log.trace("Driver has shutdown.");
        } else log.trace("Driver already shutdown.");
    }

}
