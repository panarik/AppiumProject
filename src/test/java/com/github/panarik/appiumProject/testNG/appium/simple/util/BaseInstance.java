package com.github.panarik.appiumProject.testNG.appium.simple.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Класс, с единым инстансом для использования в тестах.
 * При каждом конкретном запуске тестов, класс определяет подключенное устройство и создаёт конкретный инстанс для него.
 */
public class BaseInstance {

    //временная переменная
    String osName = "ANDROD"; //Позже будет переключение на Android и iOS

    // Создаём две переменные.
    // При подключении различных девайсов переменные будут отображать OS конкретного девайса.
    public enum OS {
        ANDROID,
        IOS
    }

    //создаём объект инстанса, чтобы через него получать отдельно драйвер iOS и отдельно драйвер Android, если это необходимо
    public static BaseInstance instance = new BaseInstance();

    public AppiumDriver<MobileElement> appiumDriver; // Создаём общий драйвер. В дальнейшем он будет преобразован в androidDriver или iOSDriver при подключении конкретного устройства.
    public AndroidDriver<MobileElement> androidDriver;
    public IOSDriver<MobileElement> iOSDriver;

    public void start() {
        if (appiumDriver !=null) {
            return;
        }
        // Начинаем установку девайса.
        DesiredCapabilities cap = new DesiredCapabilities();
        switch (osName) {
            case ("ANDROD") : {
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                cap.setCapability(MobileCapabilityType.VERSION, "10");
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 9");
                cap.setCapability(MobileCapabilityType.UDID, "UDID");
                cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60); //через 60 сек отключаем девайс
                cap.setCapability(MobileCapabilityType.APP, "path/to/app.apk");
                cap.setCapability("unlockType", "pattern"); //тип разблокировки девайса
                cap.setCapability("unlockKey", "1234"); //ключ разблокировки

                try {
                    URL url = new URL("http://127.0.0.1:4723/wd/hub");
                    androidDriver = new AndroidDriver<>(url, cap);
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
                System.out.println(androidDriver.getSessionDetails());
                System.out.println(androidDriver.getSettings());
                androidDriver.unlockDevice();
                break;
            }
            case ("IOS") : break; // Пока пусто. В дальнейшем тут будет сетап iOS
            default:
        }
    }







}
