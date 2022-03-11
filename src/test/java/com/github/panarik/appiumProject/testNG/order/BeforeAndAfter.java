package com.github.panarik.appiumProject.testNG.order;

import org.testng.annotations.*;

public class BeforeAndAfter {

    String s = "Text";

    static {
        System.out.println("TestBeforeMethod static code");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(s + " by annotation '@BeforeMethod'");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println(s + " by annotation '@BeforeClass'");
    }

    @BeforeTest
    public void BeforeTest() {
        System.out.println(s + " by annotation '@BeforeTest'");
    }

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println(s + " by annotation '@BeforeSuite'");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(s + " by annotation '@AfterMethod'");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(s + " by annotation '@AfterClass'");
    }

    @AfterTest
    public void afterTest() {
        System.out.println(s + " by annotation '@AfterTest'");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(s + " by annotation '@AfterSuite'");
    }

}
