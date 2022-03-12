package com.github.panarik.appiumProject.model;

public class User {
    String username;
    String password;
    String email;
    String displayName;
    String languageSetting;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
