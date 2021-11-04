package com.github.panarik.appiumProject.selenium;

import com.github.panarik.appiumProject.selenium.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

public class WaitTest extends BaseTest {

    private static WebElement search;


    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://www.easemytrip.com/");
        driver.manage().window().fullscreen();
    }

    //неявное ожидание
    @Test
    public void test_Implicit_ThreadSleep() {
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
        picDate();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        search.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.findElement(By.cssSelector(".card.fltResult"));
    }

    //неявное ожидание
    @Test
    public void test_Implicit_driverPageLoad() {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        picDate();
        wait.until(ExpectedConditions.visibilityOf(search));
        search.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card.fltResult")));
    }

    private void picDate() {
        WebElement fromEdit = driver.findElement(By.id("FromSector_show"));
        WebElement toEdit = driver.findElement(By.id("Editbox13_show"));
        search = driver.findElement(By.cssSelector("[value='Search']"));
        //выбираем дату вылета
        WebElement dateDeparture = driver.findElement(By.id("ddate"));
        dateDeparture.click();
        WebElement fromDate = driver.findElement(By.cssSelector("[id='fst_" + getDate(1) + "/11/2021']"));
        fromDate.click();
        //выбираем дату прилета
        WebElement dateArrive = driver.findElement(By.id("rdate"));
        dateArrive.click();
        WebElement toDate = driver.findElement(By.cssSelector("[id='fst_" + getDate(2) + "/11/2021']"));
        toDate.click();
    }

    private String getDate(int appendDays) {
        DateFormat df = new SimpleDateFormat("dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, appendDays);
        String dayOfMonth = df.format(calendar.getTime());
        int dayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK) - 1);
        System.out.println("day of month: " + dayOfMonth + ", day of week: " + dayOfWeek);
        return dayOfWeek + "_" + dayOfMonth;
    }
}
