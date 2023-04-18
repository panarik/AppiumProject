package com.github.panarik.appiumProject.tools.configs.capabilities;

import io.appium.java_client.ios.options.XCUITestOptions;
import lombok.Data;

import java.net.URL;

/**
 * Final set of desired capabilities for setup Appium.
 */

public class OptionalsHolder {

    private XCUITestOptions options;
    private URL url;

    public XCUITestOptions getOptions() {
        return options;
    }

    public OptionalsHolder setOptions(XCUITestOptions options) {
        this.options = options;
        return this;
    }

    public URL getUrl() {
        return url;
    }

    public OptionalsHolder setUrl(URL url) {
        this.url = url;
        return this;
    }

}
