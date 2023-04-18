package com.github.panarik.appiumProject.tools.configs;

import com.github.panarik.appiumProject.tools.configs.data.TestData;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {

    public TestData getData() {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("src/test/resources/settings.json"));
        } catch (IOException e) {
            throw new IllegalArgumentException("Cant parse settings.json");
        }
        return new Gson().fromJson(reader, TestData.class);
    }

}
