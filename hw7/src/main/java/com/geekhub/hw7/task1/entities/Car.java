package com.geekhub.hw7.task1.entities;

public class Car {
    private String color;
    private int maxSpeed;
    private String type;
    private String model;

    public Car(String color, int maxSpeed, String type, String model) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.type = type;
        this.model = model;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
