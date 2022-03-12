package com.github.panarik.appiumProject.model.base;


/**
 * Класс в котором описывается элемент экрана с локатором.
 * Все элементы заранее помещаются в объект экрана и вызываются лишь когда это необходимо
 */
public class MobileItem {

    private final String name;
    private final String locatorType; // Тип локатора. Из типа локатора и текста локатора составляется само тело локатора, которое и запускается.
    private final String locatorBody; // Тело локатора.

    public MobileItem(String name, String locatorType, String locatorBody) {
        this.name = name;
        this.locatorType = locatorType;
        this.locatorBody = locatorBody;
    }

    public String getName() {
        return name;
    }

    public String getLocatorType() {
        return locatorType;
    }

    public String getLocatorBody() {
        return locatorBody;
    }


}
