package com.geekhub.hw7.task1;

import com.geekhub.hw7.task1.entities.Car;
import com.geekhub.hw7.task1.entities.Cat;
import com.geekhub.hw7.task1.entities.Human;

import java.lang.reflect.Field;

public class BeanRepresenter {
    private static void print(Object object) throws IllegalAccessException {
        System.out.println("Class = " + object.getClass().getName());
        for (Field x : object.getClass().getDeclaredFields()) {
            x.setAccessible(true);
            System.out.println(x.getName() + ": " + x.get(object));
            x.setAccessible(false);
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Cat cat = new Cat("Black", 3, 4, 35);
        Car car = new Car("black", 190, "Sedan", "RX-7");
        Human human = new Human(180, "male", 22, 75);
        print(cat);
        System.out.println();
        print(car);
        System.out.println();
        print(human);
    }
}
