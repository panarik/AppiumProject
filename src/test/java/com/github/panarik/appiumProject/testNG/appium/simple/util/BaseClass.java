package com.github.panarik.appiumProject.testNG.appium.simple.util;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    //Метод выполняется первым при старте TestNG
    @BeforeMethod
    public void setup() {
        BaseInstance.instance.start();
    }

    @AfterTest
    public void shutdown() {
        driver.quit();
    }


}
