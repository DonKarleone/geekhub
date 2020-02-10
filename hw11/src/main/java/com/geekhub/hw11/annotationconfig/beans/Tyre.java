package com.geekhub.hw11.annotationconfig.beans;

public abstract class Tyre {
    private int size;
    private String name;

    public Tyre(int size, String name) {
        this.size = size;
        this.name = name;
        action();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void action() {
        System.out.println("Tyre size = " + size + ", name = " + name);
    }
}
