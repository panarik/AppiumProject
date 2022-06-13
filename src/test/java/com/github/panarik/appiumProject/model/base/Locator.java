package com.github.panarik.appiumProject.model.base;

public class Locator {

    private final String androidLocatorBody;
    private final String androidLocatorType;
    private final String iOSLocatorBody;
    private final String iOSLocatorType;

    public Locator(String androidLocator, String iOSLocator) {
        this.androidLocatorBody = androidLocator;
        this.iOSLocatorBody = iOSLocator;

        // Setup Android locator type.
        if (androidLocator.startsWith("//")) this.androidLocatorType = "xpath";
        else this.androidLocatorType = "id";

        // Setup iOS locator type.
        if (iOSLocator.startsWith("//")) this.iOSLocatorType = "xpath";
        else this.iOSLocatorType = "id";
    }

    public String getType() {
        if (Configs.OS == "IOS") return this.iOSLocatorType;
        else return this.androidLocatorType;
    }

    public String getBody() {
        if (Configs.OS == "IOS") return this.iOSLocatorBody;
        else return this.androidLocatorBody;
    }

}
