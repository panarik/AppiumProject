package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.model.base.Configs;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Класс, с единым инстансом для использования в тестах.
 * При каждом конкретном запуске тестов, класс определяет подключенное устройство и создаёт конкретный инстанс для него.
 */
public final class AppiumController {

    static AppiumController instance;

    // Создаём драйвера.
    private AndroidDriver<MobileElement> androidDriver;
    private IOSDriver<MobileElement> iOSDriver;

    private AppiumController() {
    }

    // Вызывается единственный объект
    // ToDo: подумать как будет работать с многопоточкой. Обернуть в ЛокалТред.
    public static AppiumController getController() {
        if(instance==null) {
            instance = new AppiumController();
        }
        return instance;
    }

    // Сетапим Android driver.
    // Можно проводить несколько раз на единственном объекте.
    public void setupAndroid() {
        DesiredCapabilities cap = new DesiredCapabilities();
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

        //сетап дефолтного ожидания
        androidDriver.manage().timeouts().implicitlyWait(Configs.GLOBAL_WAITING, TimeUnit.SECONDS);
    }

    public void setupIOS() {
        //ToDo: Сделать iOS.
    }

    /**
     * Вызываем AndroidDriver из пакета контроллеров.
     *
     * @return AndroidDriver
     */
     AndroidDriver<MobileElement> getAndroidDriver() {
        return androidDriver;
    }

    /**
     * Вызываем IOSDriver из пакета контроллеров.
     *
     * @return IOSDriver
     */
    IOSDriver<MobileElement> getIOSDriver() {
        return iOSDriver;
    }

    /**
     * Тушим все драйверы.
     */
    public void stop() {
        if (androidDriver != null) androidDriver.quit();
        if (iOSDriver != null) iOSDriver.quit();
    }

}
