package com.github.panarik.appiumProject.tools.configs.data;

import lombok.Data;

@Data
public class Device {

    private String platformName;
    private String platformVersion ;
    private String udid;
    private String automationName;
    private String unlockType;
    private String unlockKey;

}
