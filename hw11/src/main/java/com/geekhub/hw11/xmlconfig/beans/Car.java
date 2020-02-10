package com.geekhub.hw11.xmlconfig.beans;

import java.util.List;

public class Car {
    private Engine engine;
    private List<Wheel> wheelList;

    public Car(Engine engine, List<Wheel> wheelList) {
        this.engine = engine;
        this.wheelList = wheelList;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public List<Wheel> getWheelList() {
        return wheelList;
    }

    public void setWheelList(List<Wheel> wheelList) {
        this.wheelList = wheelList;
    }

    public void action() {
        System.out.println("------------------------------------------------------");
        System.out.println("Car was created : ");
        System.out.println("Engine capacity is = " + engine.getCapacity());
        System.out.println("------------------------------------------------------");
        for (Wheel wheel : wheelList) {
            Tyre tyre = wheel.getTyre();
            System.out.println("Tyre: name = " + tyre.getName() + ", size = " + tyre.getSize());
            System.out.println("Wheel id = " + wheel);
            System.out.println("------------------------------------------------------");
        }
    }
}
