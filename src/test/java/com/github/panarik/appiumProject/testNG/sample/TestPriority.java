package com.github.panarik.appiumProject.testNG.sample;

import org.testng.annotations.Test;

public class TestPriority {

    @Test(priority = 1)
    public void testOne() {
        System.out.println("Test with priority 1");
    }

    @Test(priority = 2)
    public void testTwo() {
        System.out.println("Test with priority 2");
    }

    @Test(priority = 3)
    public void testThree() {
        System.out.println("Test with priority 3");
    }

}
