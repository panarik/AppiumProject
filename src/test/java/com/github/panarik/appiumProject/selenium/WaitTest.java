package com.github.panarik.appiumProject.selenium;

import com.github.panarik.appiumProject.selenium.base.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WaitTest extends BaseTest {

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://www.easemytrip.com/");
        driver.manage().window().fullscreen();
    }

    @Test
    public void test_Implicit_ThreadWait() {
        WebElement fromEdit = driver.findElement(By.id("FromSector_show"));
        WebElement toEdit = driver.findElement(By.id("Editbox13_show"));
        WebElement search = driver.findElement(By.cssSelector("[value='Search']"));

        //выбираем дату вылета
        WebElement dateDeparture = driver.findElement(By.id("ddate"));
        dateDeparture.click();
        WebElement fromDate = driver.findElement(By.cssSelector("[id='fst_"+getDate(1)+"/11/2021']"));
        fromDate.click();

        //выбираем дату прилета
        WebElement dateArrive = driver.findElement(By.id("rdate"));
        dateArrive.click();
        WebElement toDate = driver.findElement(By.cssSelector("[id='fst_"+getDate(2)+"/11/2021']"));
        toDate.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        search.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private String getDate(int appendDays) {
        DateFormat df = new SimpleDateFormat("dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, appendDays);
        String dayOfMonth = df.format(calendar.getTime());
        int dayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK)-1);
        System.out.println("day of month: "+dayOfMonth+", day of week: "+dayOfWeek);
        return dayOfWeek+"_"+dayOfMonth;
    }

//    //неявное ожидание
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//
//    //явное ожидание
//    WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
//            .until(ExpectedConditions.presenceOfElementLocated(By.id("someId")));



}
