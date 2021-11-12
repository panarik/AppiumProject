package com.github.panarik.appiumProject.driver;

import io.appium.java_client.android.AndroidDriver;

public class DriverAndroid {

    //инициализируем общий драйвер
    public static AndroidDriver driver;

    //получаем драйвер из любого места проекта
    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void setDriver(AndroidDriver driverInsert) {
        driver = driverInsert;
        System.out.println("setting driver with: "+driverInsert);
    }


}
