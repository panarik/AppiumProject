package com.github.panarik.appiumProject.testNG.appium.pageFactoryPattern2site.pages;

import com.github.panarik.appiumProject.driver.AppDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {

    public AuthPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @AndroidFindBy(id = "com.github.panarik.smartFeatures:id/sign_in_without_auth")
    public AndroidElement sign_in_without_auth;
}
