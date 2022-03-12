package com.github.panarik.appiumProject.model.base;


/**
 * Класс в котором описывается элемент экрана с локатором.
 * Все элементы заранее помещаются в объект экрана и вызываются лишь когда это необходимо
 */
public class MobileItem {

    private String name;
    private String locatorType; // Тип локатора. Из типа локатора и текста локатора составляется само тело локатора, которое и запускается.
    private String locator;

    public String getName() {
        return name;
    }

    public String getLocatorType() {
        return locatorType;
    }

    public String getLocator() {
        return locator;
    }
}
