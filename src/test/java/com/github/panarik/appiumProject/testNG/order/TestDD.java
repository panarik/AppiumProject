package com.github.panarik.appiumProject.testNG.order;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDD extends BB {

    String s = "TestDD text";

    @Test
    public void testDD() {
        System.out.println(s);
    }

}
