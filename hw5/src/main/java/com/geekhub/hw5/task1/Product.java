package com.geekhub.hw5.task1;

class Product {
    private String name;
    private double price;
    private double quantity;

    Product(String name, double price, double quantity) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    double getQuantity() {
        return quantity;
    }

    public String toString() {
        return name + ": price - " + price + ", quantity - " + quantity;
    }
}
