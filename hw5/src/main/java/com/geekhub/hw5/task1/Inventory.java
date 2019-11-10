package com.geekhub.hw5.task1;

import java.util.ArrayList;
import java.util.Optional;

class Inventory {
    ArrayList<Product> products;

    Inventory() {
        products = new ArrayList<>();
    }

    void addProduct(String name, double price, double quantity) {
        Product newProduct = new Product(name, price, quantity);
        products.add(newProduct);
    }

    Product search(String name){
        Optional<Product> any = products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findAny();
        return any.orElse(null);
    }

    double countSum() {
        return products.stream()
                .map(Product::getTotal)
                .reduce((total, total1) -> total + total1).get();
    }
}