package com.geekhub.hw11.javaconfig.beans;

public class Wheel {
    private Tyre tyre;

    public Wheel(Tyre tyre) {
        this.tyre = tyre;
        action();
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public void action() {
        System.out.println("Wheel was created");
    }
}
