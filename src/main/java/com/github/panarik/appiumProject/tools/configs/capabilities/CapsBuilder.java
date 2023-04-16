package com.github.panarik.appiumProject.tools.configs.capabilities;

import com.github.panarik.appiumProject.tools.configs.data.TestData;

public interface CapsBuilder {

    void setEnvironment(TestData data);

    void setDevice(TestData data);

    CapsHolder build();

}
