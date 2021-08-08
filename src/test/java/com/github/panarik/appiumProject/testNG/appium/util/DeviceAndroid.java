package com.github.panarik.appiumProject.testNG.appium.util;

public class DeviceAndroid {

    private String platformName;
    private String version;
    private String deviceName;
    private String udid;
    private String appPath;
    private String unlockType;
    private String unlockKey;

    public String getPlatformName() {
        return platformName;
    }

    @Override
    public String toString() {
        return "DeviceAndroid{" +
                "platformName='" + platformName + '\'' +
                ", version='" + version + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", udid='" + udid + '\'' +
                ", appPath='" + appPath + '\'' +
                ", unlockType='" + unlockType + '\'' +
                ", unlockKey='" + unlockKey + '\'' +
                '}';
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public String getUnlockType() {
        return unlockType;
    }

    public void setUnlockType(String unlockType) {
        this.unlockType = unlockType;
    }

    public String getUnlockKey() {
        return unlockKey;
    }

    public void setUnlockKey(String unlockKey) {
        this.unlockKey = unlockKey;
    }
}
