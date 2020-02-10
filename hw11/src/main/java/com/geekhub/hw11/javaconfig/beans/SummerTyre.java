package com.geekhub.hw11.javaconfig.beans;

public class SummerTyre extends Tyre {

    public SummerTyre(int size, String name) {
        super(size, name);
    }

    @Override
    public void action() {
        System.out.println("Summer tyre was chosen");
    }
}
