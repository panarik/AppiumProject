package com.github.panarik.appiumProject.appium.pageFactoryPattern.util;

import com.github.panarik.appiumProject.testNG.appium.util.DeviceSettings;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SetupDevice {

    public static AndroidDriver<MobileElement> driver;

    public static void redmi9() {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, DeviceSettings.setup().getPlatformName());
        cap.setCapability(MobileCapabilityType.VERSION, DeviceSettings.setup().getVersion());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceSettings.setup().getDeviceName());
        cap.setCapability(MobileCapabilityType.UDID, DeviceSettings.setup().getUdid());
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60); //через 60 сек отключаем девайс
        cap.setCapability(MobileCapabilityType.APP, DeviceSettings.setup().getAppPath());
        cap.setCapability("unlockType", DeviceSettings.setup().getUnlockType()); //тип разблокировки девайса
        cap.setCapability("unlockKey", DeviceSettings.setup().getUnlockKey()); //ключ разблокировки
        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<>(url, cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //смотрим настройки сессии
        System.out.println(driver.getSessionDetails());
        //смотрим настройки двайвера
        System.out.println(driver.getSettings());

        //разблокировка девайса
        driver.unlockDevice();

        //ДЕБАГ
        System.out.println();
    }

}
