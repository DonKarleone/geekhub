package com.geekhub.hw11.annotationconfig.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Car {
    private Engine engine;
    private List<Wheel> wheelList;

    @Autowired
    public Car(Engine engine, Wheel wheel1, Wheel wheel2, Wheel wheel3, Wheel wheel4) {
        this.engine = engine;
        this.wheelList = new ArrayList<>();
        wheelList.add(wheel1);
        wheelList.add(wheel2);
        wheelList.add(wheel3);
        wheelList.add(wheel4);
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
