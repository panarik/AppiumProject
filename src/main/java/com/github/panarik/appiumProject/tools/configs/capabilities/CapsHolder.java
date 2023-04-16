package com.github.panarik.appiumProject.tools.configs.capabilities;

import lombok.Data;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Final set of desired capabilities for setup Appium.
 */
@Data
public class CapsHolder {
    private DesiredCapabilities caps;
    private URL url;
}
