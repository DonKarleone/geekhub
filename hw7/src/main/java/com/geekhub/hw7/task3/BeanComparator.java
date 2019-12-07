package com.geekhub.hw7.task3;

import com.geekhub.hw7.task3.entity.Car;

import java.lang.reflect.Field;

public class BeanComparator {
    private static <T> void comparator(T first, T second) throws IllegalAccessException {
        if (first != null && second != null) {
            Class beanClass = first.getClass();
            for (Field field : beanClass.getDeclaredFields()) {
                field.setAccessible(true);
                Object firstValue = field.get(first);
                Object secondValue = field.get(second);
                System.out.println(field.getName()
                        + " "
                        + firstValue
                        + " "
                        + secondValue
                        + " Match: "
                        + firstValue.equals(secondValue));
                field.setAccessible(false);
            }
        } else {
            System.out.println("Object is null");
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Car a = new Car(120, "RX-7", "coupe", "black", 230);
        Car b = new Car(120, "RX-8", "sedan", "black", 225);
        comparator(a, b);
    }
}