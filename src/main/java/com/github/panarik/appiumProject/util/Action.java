package com.github.panarik.appiumProject.util;

import com.github.panarik.appiumProject.driver.AppDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {

    public static void click(By byElement){
        new WebDriverWait(AppDriver.getDriver(), 20).until(ExpectedConditions.presenceOfElementLocated(byElement)).click();
    }

}
