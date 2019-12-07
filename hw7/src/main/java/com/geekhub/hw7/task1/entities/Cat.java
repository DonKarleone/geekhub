package com.geekhub.hw7.task1.entities;

public class Cat {
    private String color;
    private int age;
    private int legCount;
    private int fullLength;

    public Cat(String color, int age, int legCount, int fullLength) {
        this.color = color;
        this.age = age;
        this.legCount = legCount;
        this.fullLength = fullLength;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLegCount() {
        return legCount;
    }

    public void setLegCount(int legCount) {
        this.legCount = legCount;
    }

    public int getFullLength() {
        return fullLength;
    }

    public void setFullLength(int fullLength) {
        this.fullLength = fullLength;
    }
}
