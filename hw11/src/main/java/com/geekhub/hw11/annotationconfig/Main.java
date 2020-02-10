package com.geekhub.hw11.annotationconfig;

import com.geekhub.hw11.annotationconfig.beans.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.geekhub.hw11.annotationconfig.beans");
        Car car = context.getBean(Car.class);
        car.action();
        System.out.println("annotationConfig");
    }
}
