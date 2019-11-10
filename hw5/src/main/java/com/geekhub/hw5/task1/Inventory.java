package com.geekhub.hw5.task1;

import java.util.ArrayList;
import java.util.Iterator;

class Inventory {
    ArrayList<Product> products;

    Inventory() {
        products = new ArrayList<>();
    }

    void addProduct(String name, double price, double quantity) {
        Product newProduct = new Product(name, price, quantity);
        products.add(newProduct);
    }

    Product search(String name) {
        Iterator<Product> iter = products.iterator();
        Product product;

        while (iter.hasNext()) {
            product = iter.next();
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    double countSum() {
        return products.stream()
                .map(Product::getTotal)
                .reduce((total, total1) -> total + total1).get();
    }
}