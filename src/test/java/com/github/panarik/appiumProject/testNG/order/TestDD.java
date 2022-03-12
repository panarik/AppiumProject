package com.github.panarik.appiumProject.testNG.order;

import org.testng.annotations.Test;

public class TestDD extends BB {

    String s1 = "TestDD text1";
    String s2 = "TestDD text2";

    @Test
    public void testDD1() {
        System.out.println(s1);
    }

    @Test
    public void testDD2() {
        System.out.println(s2);
    }

}
