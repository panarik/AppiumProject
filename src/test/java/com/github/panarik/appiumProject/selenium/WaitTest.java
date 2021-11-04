package com.github.panarik.appiumProject.selenium;

import com.github.panarik.appiumProject.selenium.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class WaitTest extends BaseTest {

    private static WebElement search;

    @BeforeEach
    public void init() {
        driver.manage().window().fullscreen();
    }

    //неявное ожидание
    @Test
    public void test_Implicit_ThreadSleep() {
        driver.get("https://www.easemytrip.com/");
        picDate();
        try {
            Thread.sleep(1000);
            search.click();
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector(".card.fltResult"));
    }

    //неявное ожидание
    @Test
    public void test_Implicit_driverWait() {
        driver.get("https://www.easemytrip.com/");
        picDate();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        search.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.findElement(By.cssSelector(".card.fltResult"));
    }

    //неявное ожидание
    @Test
    public void test_Implicit_driverPageLoad() {
        driver.get("https://www.easemytrip.com/");
        picDate();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        try {
            search.click();
        } catch (WebDriverException e) {
            System.err.println("Search button does not found!");
        }
        //ToDo. выкидывает ошибку:
        // поток:  AsyncHttpClient-1-4.
        // Класс: org.asynchttpclient.netty.handler.WebSocketHandler - onError
        // Подумать почему.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        try {
            driver.findElement(By.cssSelector(".card.fltResult"));
        } catch (WebDriverException e) {
            System.err.println("RESULT AIRLINES CARDS haz not found!");
        }

    }

    //явное ожидание
    @Test
    public void test_explicit() {
        driver.get("https://www.easemytrip.com");
        driver.manage().window().fullscreen();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        picDate();
        wait.until(ExpectedConditions.visibilityOf(search));
        search.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card.fltResult")));
    }

    private void picDate() {
        search = driver.findElement(By.cssSelector("[value='Search']"));
        //выбираем дату вылета
        driver.findElement(By.id("ddate")).click();
        driver.findElement(By.cssSelector("[id='" + getDate(1) + "/11/2021']")).click();
        //выбираем дату прилета
        driver.findElement(By.id("rdate")).click();
        driver.findElement(By.cssSelector("[id='" + getDate(2) + "/11/2021']")).click();
    }

    private String getDate(int appendDays) {
        DateFormat day = new SimpleDateFormat("dd");
        DateFormat week = new SimpleDateFormat("W");
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.add(Calendar.DAY_OF_MONTH, appendDays);
        String dayOfMonth = day.format(calendar.getTime());
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        int dayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK) - 1);
        Map<Integer, String> weekMap = new HashMap<>();
        weekMap.put(1, "fst");
        weekMap.put(2, "snd");
        weekMap.put(3, "trd");
        weekMap.put(4, "frth");
        weekMap.put(5, "fiv");
        System.out.println("number of week: "+weekOfMonth+", day of month: " + dayOfMonth + ", day of week: " + dayOfWeek);
        return weekMap.get(weekOfMonth)+"_"+dayOfWeek + "_" + dayOfMonth;
    }
}
