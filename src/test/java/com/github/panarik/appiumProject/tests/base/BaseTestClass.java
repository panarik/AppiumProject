package com.github.panarik.appiumProject.tests.base;

import com.github.panarik.appiumProject.controller.AppiumInstance;
import com.github.panarik.appiumProject.model.screen.signIn.Menu;
import com.github.panarik.appiumProject.model.screen.signIn.SignIn;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Класс в котором запускается первоначальные методы и завершающие тесты методы
 */
public class BaseTestClass {

    AppiumInstance instance;

    //Setup pages
    protected SignIn signIn = new SignIn();
    protected Menu menu = new Menu();

    @BeforeTest
    public void start() {
        String osName = "ANDROID"; // Можно сделать переключение на iOS.
        System.out.println(osName + " driver: setup");
        instance = new AppiumInstance();
        instance.setup(osName);
        System.out.println(osName + " driver: ready");
    }

    @AfterTest
    public void shutdown() {
        instance.stop();
    }

}
