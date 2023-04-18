package com.github.panarik.appiumProject.tools.configs.capabilities;

import io.appium.java_client.ios.options.XCUITestOptions;
import lombok.Data;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Build optional for IOS.
 */
@Data
public class IOSOptionsBuilder implements OptionsBuilder {

    private final OptionalsHolder holder = new OptionalsHolder();
    private final XCUITestOptions options = new XCUITestOptions();
    private final String udid;

    public IOSOptionsBuilder(String udid) {
        this.udid = udid;
    }

    public OptionalsHolder build() {
        options
                .setUdid(udid)
                .setBundleId("com.google.Maps");
        holder
                .setOptions(options)
                .setUrl(getAppiumURL());
        return holder;
    }

    private URL getAppiumURL() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Cant create appium server url.");
        }
    }
}
