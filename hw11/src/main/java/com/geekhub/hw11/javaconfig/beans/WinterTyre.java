package com.geekhub.hw11.javaconfig.beans;

public class WinterTyre extends Tyre {

    public WinterTyre(int size, String name) {
        super(size, name);
    }

    @Override
    public void action() {
        System.out.println("Winter tyre was chosen");
    }
}
