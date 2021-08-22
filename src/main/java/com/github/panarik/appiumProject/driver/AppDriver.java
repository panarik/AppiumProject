package com.github.panarik.appiumProject.driver;

import org.openqa.selenium.WebDriver;

public class AppDriver {

    //инициализируем общий драйвер
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //получаем драйвер из любого места проекта
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInsert) {
        driver.set(driverInsert);
        System.out.println("setting driver");
    }


}
