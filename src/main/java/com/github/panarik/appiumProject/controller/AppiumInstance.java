package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.tools.Log;
import com.github.panarik.appiumProject.tools.configs.capabilities.CapsHolder;
import com.github.panarik.appiumProject.tools.configs.capabilities.LocalCapsBuilder;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AppiumInstance {

    static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>(); // Common driver.
    public static final Log log = new Log();

    public void setup(String platformName, String udid) {
        install(new LocalCapsBuilder(platformName, udid).build());
        configure();


//        switch (OS) {
//            case ("ANDROID") -> {
//                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
////                cap.setCapability(MobileCapabilityType.VERSION, config.getAndroid().get("version"));
////                cap.setCapability(MobileCapabilityType.UDID, config.getAndroid().get("udid"));
//                cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
////                cap.setCapability(MobileCapabilityType.APP, config.getAndroid().get("app")); // for apps in repo.
////                cap.setCapability("appActivity", config.getAndroid().get("appActivity")); // for installed apps.
////                cap.setCapability("appPackage", config.getAndroid().get("appPackage")); // for installed apps.
////                cap.setCapability("unlockType", config.getAndroid().get("unlockType"));
////                cap.setCapability("unlockKey", config.getAndroid().get("unlockKey"));
//                try {
//                    URL url = new URL("http://127.0.0.1:4723/wd/hub");
//                    DRIVER.set(new AndroidDriver(url, cap));
//                } catch (
//                        MalformedURLException e) {
//                    e.printStackTrace();
//                }
//            }
//            case ("IOS") -> {
//                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
////                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getIOS().get("platformVersion"));
////                cap.setCapability(MobileCapabilityType.DEVICE_NAME, config.getIOS().get("deviceName"));
//                cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
////                cap.setCapability(MobileCapabilityType.UDID, config.getIOS().get("udid"));
////                cap.setCapability(MobileCapabilityType.APP, config.getIOS().get("app"));
//                try {
//                    URL url = new URL("http://127.0.0.1:4723/wd/hub");
//                    DRIVER.set(new IOSDriver(url, cap));
//                } catch (
//                        MalformedURLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    private void install(CapsHolder caps) {

        log.info("Created " + caps.getCaps().getPlatformName() + " session.");
    }

    private void configure() {
        DRIVER.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void stop() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            log.info("Driver has shutdown.");
        } else log.info("Driver already shutdown.");
    }

}
