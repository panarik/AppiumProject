package com.github.panarik.appiumProject.testNG.appium.simple.util;

import com.github.panarik.appiumProject.testNG.appium.simple.screen.signIn.SignIn;
import com.github.panarik.appiumProject.testNG.appium.simple.screen.signIn.SignInAndroid;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Класс в котором запускается первоначальные методы и завершающие тесты методы
 */
public class BaseTestClass {

    public AppiumController controller;
    String osName = "ANDROID"; // Можно сделать переключение на iOS.

    // Создаем переменные для всех экранов.
    // В дальнейшем этим переменным будет присвоен Android или iOS класс в зависимости от подключенного к проекту девайса.
    protected SignIn signIn;

    @BeforeTest
    public void start() {
        switch (osName) {
            case ("ANDROID") : {
                controller = new AppiumController();
                controller.setupAndroid();
                // Перенаправляем все экраны на Android классы.
                // В тестах будут дергать переменные интерфейсов, а интерфейсы в данном случае будут ссылаться на Android экраны.
                // Также Android наследуют класс AndroidBase в котором собраны все необходимые методы для прогона тестов на Android
                signIn = new SignInAndroid();
            }
            case ("IOS") : {
                controller = new AppiumController();
                controller.setupIOS();
                // Перенаправляем все экраны на Android классы.
                // В тестах будут дергать переменные интерфейсов, а интерфейсы в данном случае будут ссылаться на Android экраны.
                // Также Android наследуют класс AndroidBase в котором собраны все необходимые методы для прогона тестов на Android
                //ToDo:
                //signIn = new SignInIOS();
            }
        }
    }

    @AfterTest
    public void shutdown() {
        controller.stop();
    }

    protected void failAfterWaiting(MobileItem mobileitem) {
        Assert.fail("Элемент " + mobileitem.getName() + " не найден");
    }

}
