package com.geekhub.hw7.task3.entity;

public class A {
    private int maxCount;
    private String model;
    private String type;
    private String color;
    private int maxSpeed;

    public A(int maxCount, String model, String type, String color, int maxSpeed) {
        this.maxCount = maxCount;
        this.model = model;
        this.type = type;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
