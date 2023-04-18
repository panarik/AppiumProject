package com.github.panarik.appiumProject.tools.configs.data;

import lombok.Data;

@Data
public class Device {
    private String bundleId;
    private String platformName;
    private String udid;
    private String automationName;
}
