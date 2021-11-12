package com.github.panarik.appiumProject.pages;

import com.github.panarik.appiumProject.util.Action;
import com.github.panarik.appiumProject.util.Wait;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class AuthPage extends BasePage {

    //Annotations
    @AndroidFindBy(id = "sign_in_logo")
    public AndroidElement sign_in_logo;

    @AndroidFindBy(id = "sign_in_without_auth")
    public AndroidElement sign_in_without_auth;

    @AndroidFindBy(id = "chat_toggleSingUpTextView")
    public AndroidElement chat_toggleSingUpTextView;

    //By
    By chat_toggleSingUpTextViewBy = By.id("chat_toggleSingUpTextView");
    //MobileBy
    public By by_signIn_without = MobileBy.xpath("//android.widget.Button[@text='ПРОДОЛЖИТЬ БЕЗ РЕГИСТРАЦИИ']");

    //Actions
    public void severalClicks() {
        Action.click(chat_toggleSingUpTextViewBy);
        Wait.second(1);
        Action.click(chat_toggleSingUpTextViewBy);
        Wait.second(1);
    }

    public void onboardingScenario() {
        Action.click(sign_in_without_auth);
        Wait.second(1);
        Action.swipeTo("Drag and drop"); //ToDo: Перенести на отдельный Page
    }

}
