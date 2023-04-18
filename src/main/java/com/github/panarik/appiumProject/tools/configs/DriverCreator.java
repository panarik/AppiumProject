package com.github.panarik.appiumProject.tools.configs;

import com.github.panarik.appiumProject.tools.Log;
import com.github.panarik.appiumProject.tools.configs.capabilities.OptionalsHolder;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

public class DriverCreator {

    private final OptionalsHolder optionals;
    private final Log log = new Log();

    public DriverCreator(OptionalsHolder caps) {
        this.optionals = caps;
    }

    public WebDriver create() {
        return new IOSDriver(optionals.getUrl(), optionals.getOptions());
    }

}
