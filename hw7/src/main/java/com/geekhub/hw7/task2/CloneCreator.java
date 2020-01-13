package com.geekhub.hw7.task2;

import com.geekhub.hw7.task2.entities.A;
import com.geekhub.hw7.task2.entities.B;
import com.geekhub.hw7.task2.entities.C;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CloneCreator {
        private static void getClassInformation(Object object) throws IllegalAccessException {
        if (object != null) {
            System.out.println("Class name : " + object.getClass().getName());
            System.out.println("Superclass : " + object.getClass().getSuperclass().getName());
            for (Field x : object.getClass().getDeclaredFields()) {
                x.setAccessible(true);
                System.out.println(x.getName() + ": " + x.get(object));
                x.setAccessible(false);
            }
            System.out.println("Methods :");
            for (Method x : object.getClass().getDeclaredMethods()) {
                System.out.println(x.getName());
            }
            System.out.println();
        } else {
            System.out.println("object = null");
        }
    }

    private static Object copyClass(Object object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Object copy = object.getClass().getConstructor().newInstance();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Field copyField = copy.getClass().getDeclaredField(field.getName());
            copyField.setAccessible(true);
            copyField.set(copy, field.get(object));
            field.setAccessible(false);
            copyField.setAccessible(false);
        }
        return copy;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        A a = new A();
        a.setParametrA(303);
        B b = new B();
        b.setParametrB(2020);
        C c = new C();
        c.setParametrC(22222);
        Object copyA = copyClass(a);
        Object copyB = copyClass(b);
        Object copyC = copyClass(c);
        getClassInformation(a);
        System.out.println("copy");
        getClassInformation(copyA);
        System.out.println("-----------------------------------------------------------------------------------------");
        getClassInformation(b);
        System.out.println("copy");
        getClassInformation(copyB);
        System.out.println("-----------------------------------------------------------------------------------------");
        getClassInformation(c);
        System.out.println("copy");
        getClassInformation(copyC);
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
