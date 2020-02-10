package com.geekhub.hw11.javaconfig.beans;

public class Engine {
    private int capacity;

    public Engine(int capacity) {
        this.capacity = capacity;
        action();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void action() {
        System.out.println("Engine is created ");
    }
}
