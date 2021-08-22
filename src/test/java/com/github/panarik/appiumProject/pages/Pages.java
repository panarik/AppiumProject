package com.github.panarik.appiumProject.pages;

import com.github.panarik.appiumProject.driver.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Pages {

    public Pages() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

}
