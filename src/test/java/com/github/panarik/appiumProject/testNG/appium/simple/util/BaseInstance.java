package com.github.panarik.appiumProject.testNG.appium.simple.util;

import com.github.panarik.appiumProject.testNG.appium.simple.screen.signIn.SignIn;
import com.github.panarik.appiumProject.testNG.appium.simple.screen.signIn.SignInAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.github.panarik.appiumProject.testNG.appium.simple.util.Configs.GLOBAL_WAITING;

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

    private AppiumDriver<MobileElement> driver; // Создаём общий драйвер. В дальнейшем он будет преобразован в androidDriver или iOSDriver при подключении конкретного устройства.


    // Создаем переменные для всех экранов.
    // В дальнейшем этим переменным будет присвоен Android или iOS класс в зависимости от подключенного к проекту девайса.
    public SignIn signIn;

    public void start() {
        if (driver != null) {
            return;
        }

        // Начинаем установку девайса.
        DesiredCapabilities cap = new DesiredCapabilities();
        switch (osName) {
            case ("ANDROD"): {
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
                    driver = new AndroidDriver<>(url, cap);
                } catch (
                        MalformedURLException e) {
                    e.printStackTrace();
                }
                System.out.println(driver.getSessionDetails());
                System.out.println(driver.getSettings());

                //сетап дефолтного ожидания
                driver.manage().timeouts().implicitlyWait(GLOBAL_WAITING, TimeUnit.SECONDS);

                // Перенаправляем все экраны на Android классы.
                // В тестах будут дергать объекты интерфейсов, а интерфейсы в данном случае будут ссылаться на Android экраны.
                // Также Android наследуют класс AndroidBase в котором собраны все необходимые методы для прогона тестов на Android
                signIn = new SignInAndroid();
                break;
            }
            case ("IOS"):
                break; // Пока пусто. В дальнейшем тут будет сетап iOS
            default:
        }
    }

    public void stop() {
        if (driver != null) driver.quit();
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }


}
