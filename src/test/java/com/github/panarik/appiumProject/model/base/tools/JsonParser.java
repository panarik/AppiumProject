package com.github.panarik.appiumProject.model.base.tools;

import com.github.panarik.appiumProject.model.base.tools.data.TestData;
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
            reader = Files.newBufferedReader(Paths.get("src/test/resources/settings.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(reader, TestData.class);
    }

}
