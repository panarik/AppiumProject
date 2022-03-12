package com.github.panarik.appiumProject.tests.base;

import com.github.panarik.appiumProject.model.screen.signIn.SignIn;
import com.github.panarik.appiumProject.model.screen.signIn.SignInAndroid;
import com.github.panarik.appiumProject.model.screen.signIn.SignInIOS;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.github.panarik.appiumProject.controller.AppiumController.getController;

/**
 * Класс в котором запускается первоначальные методы и завершающие тесты методы
 */
public class BaseTestClass {

    // Создаем переменные для всех экранов.
    // В дальнейшем этим переменным будет присвоен Android или iOS класс в зависимости от подключенного к проекту девайса.
    //ToDo: Можно вообще обойтись без переменных экрана, если методы каждого PageObject будут возвращать объект этого или другого экрана.
    protected SignIn signIn;

    @BeforeTest
    public void start() {
        String osName = "ANDROID"; // Можно сделать переключение на iOS.
        switch (osName) {
            case ("ANDROID"): {
                System.out.println("Android driver: setup");
                getController().setupAndroid();
                System.out.println("Android driver: ready");

                // Перенаправляем все экраны на Android классы.
                // В тестах будут дергать переменные интерфейсов, а интерфейсы в данном случае будут ссылаться на Android экраны.
                // Также Android наследуют класс AndroidBase в котором собраны все необходимые методы для прогона тестов на Android
                signIn = new SignInAndroid();
            }
            case ("IOS"): {
                System.out.println("iOS driver: setup");
                getController().setupIOS();
                System.out.println("iOS driver: ready");
                // Перенаправляем все экраны на Android классы.
                // В тестах будут дергать переменные интерфейсов, а интерфейсы в данном случае будут ссылаться на Android экраны.
                // Также Android наследуют класс AndroidBase в котором собраны все необходимые методы для прогона тестов на Android
                //ToDo:
                signIn = new SignInIOS();
            }
        }
    }

    @AfterTest
    public void shutdown() {
        getController().stop();
    }

}
