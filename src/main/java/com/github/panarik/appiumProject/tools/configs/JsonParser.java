package com.github.panarik.appiumProject.tools.configs;

import com.github.panarik.appiumProject.tools.configs.data.TestData;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {

    private final Gson gson = new Gson();

    public TestData getData() {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("src/test/resources/settings-device.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(reader, TestData.class);
    }

}
