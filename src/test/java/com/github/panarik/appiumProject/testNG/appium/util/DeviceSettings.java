package com.github.panarik.appiumProject.testNG.appium.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public interface DeviceSettings {

    String PLATFORM_NAME = "platformName";
    String VERSION = "version";
    String DEVICE_NAME = "deviceName";
    String UDID = "udid";
    String APP = "appPath";
    String UNLOCK_TYPE = "unlockType";
    String UNLOCK_KEY = "unlockKey";



    static DeviceAndroid setup() {
        DeviceAndroid android = new DeviceAndroid();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/test/resources/device/settings.json")) {
            JSONObject deviceJSON = (JSONObject) parser.parse(reader);
            android.setPlatformName((String) deviceJSON.get(PLATFORM_NAME));
            android.setVersion((String) deviceJSON.get(VERSION));
            android.setDeviceName((String) deviceJSON.get(DEVICE_NAME));
            android.setUdid((String) deviceJSON.get(UDID));
            android.setAppPath((String) deviceJSON.get(APP));
            android.setUnlockType((String) deviceJSON.get(UNLOCK_TYPE));
            android.setUnlockKey((String) deviceJSON.get(UNLOCK_KEY));

        } catch (ClassCastException | IOException | ParseException e) {
            e.printStackTrace();
        }
        return android;
    }

}
