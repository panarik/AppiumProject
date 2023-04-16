package com.github.panarik.appiumProject.tools.configs.capabilities;

import com.github.panarik.appiumProject.tools.configs.JsonParser;
import com.github.panarik.appiumProject.tools.configs.data.TestData;
import lombok.Data;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Build capabilities for local test runs.
 */
@Data
public class LocalCapsBuilder implements CapsBuilder {

    private CapsHolder capsHolder;
    private DesiredCapabilities caps;
    private final TestData data;
    private final String platformName;
    private final String udid;

    public LocalCapsBuilder(String platformName, String udid) {
        this.data = new JsonParser().getData();
        this.platformName = platformName;
        this.udid = udid;
    }

    public void setEnvironment(TestData data) {
//        caps.setCapability();
    }

    public void setDevice(TestData data) {

    }

    public CapsHolder build() {
        return null;
    }
}
