package com.github.panarik.appiumProject.testNG.order;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCC extends BB {

    String s = "TestCC text";

    @Test
    public void testCC() {
        System.out.println(s);
    }

}
