package com.github.panarik.appiumProject.testNG.order;

import org.testng.annotations.Test;

public class TestCC extends BB {

    String s1 = "TestCC text1";
    String s2 = "TestCC text2";

    @Test
    public void testCC1() {
        System.out.println(s1);
    }

    @Test
    public void testCC2() {
        System.out.println(s2);
    }

}
