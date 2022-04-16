package com.github.panarik.appiumProject.tests;

import com.github.panarik.appiumProject.tests.base.CommonActions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestOne extends CommonActions {

    @BeforeClass
    public void setGeoToLondon() {
    }

    @Test
    public void SearchSomePlace() {

        //Pre Step: set location.
        map.setLondon();

        // Step 1: Go to search page.
        map.goToSearch();

        // Step 2: Search "Garden Museum".
        search
                .search("Garden Museum")
                .pickFirstSuggestion();

        //Step 3: Check "Garden Museum" from the list of suggestions on the map.
        map.verifySuggestion("Garden Museum");
    }

    @Test
    public void testTrue() {
        Assert.assertTrue(true);
    }
}
