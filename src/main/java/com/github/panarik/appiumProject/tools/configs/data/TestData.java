package com.github.panarik.appiumProject.tools.configs.data;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TestData {

    private Map<String, String> environment;
    private List<Device> devices;

}
