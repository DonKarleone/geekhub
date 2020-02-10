package com.geekhub.hw11.xmlconfig;

import com.geekhub.hw11.xmlconfig.beans.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Car car = context.getBean(Car.class);
        car.action();
        System.out.println("xmlConfig");
    }
}
