package com.github.panarik.appiumProject.selenium.tools;

import com.github.panarik.appiumProject.selenium.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait extends BaseTest {

    private static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    private WebElement element;

    private void waitersExample(){

        //attribute
        wait.until(ExpectedConditions.attributeContains(element, "id", "some"));
        wait.until(ExpectedConditions.attributeToBe(element, "id", "some"));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "id"));

        //

    }


}
