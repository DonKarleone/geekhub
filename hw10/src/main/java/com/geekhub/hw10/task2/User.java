package com.geekhub.hw10.task2;

public class User {
    private String name;
    private String password;

    User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
