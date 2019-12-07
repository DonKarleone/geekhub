package com.geekhub.hw7.task3;

import com.geekhub.hw7.task3.entity.A;

import java.lang.reflect.Field;

public class BeanComparator {
    private static <T> void comparator(T a, T b) {
        if(a != null && b != null) {
            Field[] aFields = a.getClass().getDeclaredFields();
            Field[] bFields = b.getClass().getDeclaredFields();
            if (aFields.length == bFields.length) {
                for (int i = 0; i < aFields.length; i++) {
                    aFields[i].setAccessible(true);
                    bFields[i].setAccessible(true);
                    try {
                        System.out.println(aFields[i].getName()
                                + " "
                                + aFields[i].get(a)
                                + " "
                                + bFields[i].get(b)
                                + " Match: "
                                + aFields[i].get(a).equals(bFields[i].get(b)));
                    } catch (IllegalAccessException e) {
                        System.out.println("Wrong object");
                        break;
                    }
                }
            } else {
                System.out.println("Objects can not be compared");
            }
        } else {
            System.out.println("Object is null");
        }
    }

    public static void main(String[] args) {
        A a = new A(120, "RX-7", "coupe", "black", 230);
        A b = new A(120, "RX-8", "sedan", "black", 225);
        comparator(a, b);
    }
}
