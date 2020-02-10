package com.geekhub.hw11.annotationconfig.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("engine")
public class Engine {
    private int capacity;

    public Engine(@Value("2") int capacity) {
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
