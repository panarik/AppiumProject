package com.github.panarik.appiumProject.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    public static WebDriver driver;

    public BasePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

}
