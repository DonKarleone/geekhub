package com.geekhub.hw7.task1.entities;

public class Human {
    private int height;
    private String gender;
    private int age;
    private int weight;

    public Human(int height, String gender, int age, int weight) {
        this.height = height;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
