package com.geekhub.hw11.javaconfig;

import com.geekhub.hw11.javaconfig.beans.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        Car car = context.getBean(Car.class);
        car.action();
        System.out.println("javaConfig");
    }
}
