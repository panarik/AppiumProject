package com.github.panarik.appiumProject.pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AuthPage extends Pages {

    @AndroidFindBy(id = "com.github.panarik.smartFeatures:id/sign_in_without_auth")
    public AndroidElement sign_in_without_auth;
}
