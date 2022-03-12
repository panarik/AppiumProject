package com.github.panarik.appiumProject.testNG.sample;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSample {

    @DataProvider (name = "db")
        public static Object[][] dbData() {
        return new Object[][] {
                {"SQLData", 1},
                {"NoSQLData", 2}
        };
    }

    //Тест с параметром из файлика testNG.
    @Parameters({"db"})
    @Test(groups = {"smoke", "regression"})
    public void test1(String db) {
        System.out.println("Test1 with parameter: "+ db);
        Assert.assertTrue(true);
    }

    //Тест с параметром из объекта.
    @Test(groups = {"regression"}, dataProvider = "db")
    public void test11(String e1, int e2) {
        System.out.println("Test11 with data: "+e1+" "+e2);
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = {"test11"}) //тест выполняется только после выполнения теста "test11"
    public void test111() {
        System.out.println("Test111");
        Assert.assertTrue(true);
    }

    @Test(dependsOnGroups = {"regression"}) //тест выполняется только после выполнения группы тестов "regression"
    public void test1111() {
        System.out.println("Test1111");
        Assert.assertTrue(true);
    }

}
