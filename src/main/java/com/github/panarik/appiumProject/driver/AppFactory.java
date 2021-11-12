package com.github.panarik.appiumProject.driver;

import com.github.panarik.appiumProject.util.DeviceSettings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {

    public static DesiredCapabilities cap;
    private static URL url;

    public static void setup() {
        //device
        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, DeviceSettings.setup().getPlatformName());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceSettings.setup().getDeviceName());
        cap.setCapability(MobileCapabilityType.UDID, DeviceSettings.setup().getUdid());
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, DeviceSettings.setup().getVersion());
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60); //через 60 сек отключаем девайс
        //app
        cap.setCapability(MobileCapabilityType.APP, DeviceSettings.setup().getAppPath());
        cap.setCapability("unlockType", DeviceSettings.setup().getUnlockType());
        cap.setCapability("unlockKey", DeviceSettings.setup().getUnlockKey());

        //set URL
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //set driver
        DriverAndroid.setDriver(new AndroidDriver<MobileElement>(url, cap));
    }
}
