package com.github.panarik.appiumProject.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

public class AppDriver {

    //инициализируем общий драйвер
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    //получаем драйвер из любого места проекта
    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(AppiumDriver driverInsert) {
        driver.set(driverInsert);
        System.out.println("setting driver");
    }


}
