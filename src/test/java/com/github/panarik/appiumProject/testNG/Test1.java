package com.github.panarik.appiumProject.testNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {

    @DataProvider (name = "db")
        public static Object[][] dbData() {
        return new Object[][] {
                {"SQLData", new Integer(1)},
                {"NoSQLData", new Integer(2)}
        };
    }

    @Parameters({"db"})
    @Test  (groups = {"smoke", "regression"})
    public void test1(String db) {
        System.out.println("Test1 with parameter: "+ db);
        Assert.assertTrue(true);
    }


    @Test (groups = {"regression"}, dataProvider = "db")
    public void test11(String e1, int e2) {
        System.out.println("Test11 with data: "+e1+" "+e2);
        Assert.assertTrue(true);
    }

    @Test
    public void test111() {
        System.out.println("Test111");
        Assert.assertTrue(true);
    }

}
