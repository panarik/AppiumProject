package com.github.panarik.appiumProject;

import com.github.panarik.appiumProject.tools.configs.JsonParser;
import com.github.panarik.appiumProject.tools.configs.data.TestData;

public class Main {

    public static void main(String[] args) {
        TestData data = new JsonParser().getData();
    }

}
