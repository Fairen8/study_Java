package com.example.ordy.Models;

public class User {

    private String name, password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
