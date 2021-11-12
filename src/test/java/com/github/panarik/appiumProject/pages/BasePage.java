package com.github.panarik.appiumProject.pages;

import com.github.panarik.appiumProject.driver.DriverAndroid;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverAndroid.getDriver()), this);
    }

}
