package com.github.panarik.appiumProject.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class Locators {

    By locatorId = By.id("chat_toggleSingUpTextView");
    By locatorClassName = By.className("android.widget.Button");
    By locatorAttributeName = By.name("nameValue");
    By locatorAttributeTag = By.tagName("tagName");
    By locatorXPath = By.xpath("//android.widget.Button[@text='ПРОДОЛЖИТЬ БЕЗ РЕГИСТРАЦИИ']");
    By locatorAccessId = MobileBy.AccessibilityId("someId");
    By locator_iOS_classChain = MobileBy.iOSClassChain("classChain");
    By locator_Android_viewTag = MobileBy.AndroidViewTag("viewTag");
}
