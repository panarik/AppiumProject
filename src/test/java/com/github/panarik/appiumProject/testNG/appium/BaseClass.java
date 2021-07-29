package com.github.panarik.appiumProject.testNG.appium;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    @BeforeTest
    public void setup() {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "ANDROID");
        //ToDo

    }

    @AfterTest
    public void shutdown() {
    }


}
