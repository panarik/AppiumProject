package com.github.panarik.appiumProject.testNG.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class BaseClass {

    public static AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setup() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.VERSION, "11");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 9");
        cap.setCapability(MobileCapabilityType.UDID, "83209d47");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60); //через 60 сек отключаем девайс
//        cap.setCapability("appActivity", "com.github.panarik.smartFeatures.activity.SignInActivity"); //если установлено на девайсе
        cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\AALEVIN8\\Documents\\GitHub\\AppiumProject\\src\\test\\resources\\apps\\app-SmartFeatures-debug.apk");
        cap.setCapability("unlockType", "pattern"); //тип разблокировки девайса
        cap.setCapability("unlockKey", "1234"); //ключ разблокировки
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
    }

    @Test
    public void simpleTest1() {
        System.out.println("Test1");
        Assert.assertTrue(true);
    }

    @AfterTest
    public void shutdown() {
        driver.quit();
    }


}
