package com.github.panarik.appiumProject.model.elements.model;

/**
 * Build locator for Android and iOS. Can use single OS and both.
 */
public class LocatorBuilder {

    private Locator locator = new Locator();

    public Locator build() {
        //ToDo: Check current OS field should be not null.
        return new Locator();
    }

}
