package com.github.panarik.appiumProject.model.elements;

import com.github.panarik.appiumProject.model.elements.model.Locator;

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

}
