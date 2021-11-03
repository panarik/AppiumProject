package com.github.panarik.appiumProject.selenium;

import com.github.panarik.appiumProject.selenium.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

    @Test
    public void test_Implicit_driverPageLoad() {
        picDate();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        try {
            search.click();
        } catch (TimeoutException e) {
            System.err.println("Search button does not found!");
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        try {
            driver.findElement(By.cssSelector(".card.fltResult"));
        } catch (TimeoutException e) {
            System.err.println("RESULT AIRLINES CARDS haz not found!");
        }

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

//    //неявное ожидание
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//
//    //явное ожидание
//    WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
//            .until(ExpectedConditions.presenceOfElementLocated(By.id("someId")));


}
