package com.github.panarik.appiumProject.model.base;

public class MobileItem {

    private final String name;
    private final Locator locator;

    public MobileItem(String name, Locator locator) {
        this.name = name;
        this.locator = locator;
    }

    public String getName() {
        return name;
    }

    public String getLocatorType() {
        return this.locator.getType();
    }

    public String getLocatorBody() {
        return this.locator.getBody();
    }

}
