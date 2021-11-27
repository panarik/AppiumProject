package com.github.panarik.appiumProject.testNG.appium.simple.util;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

/**
 * Класс в котором запускается первоначальные методы и завершающие тесты методы
 */
public class BaseTestClass {

    //Метод выполняется первым при старте TestNG
    @BeforeMethod
    public void setup() {
        BaseInstance.instance.start();
    }

    @AfterTest
    public void shutdown() {
        BaseInstance.instance.stop();
    }

}
