package com.geekhub.hw5.task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Inventory {
    private ArrayList<Product> products;
    private Scanner in = new Scanner(System.in);

    Inventory() {
        products = new ArrayList<>();
    }

    void addProduct() {
        String name;
        double price;
        double quantity;
        System.out.print("Enter name of product : ");
        name = in.next();
        Product foundProduct = search(name);
        if (foundProduct == null) {
            System.out.print("Enter price for 1kg of " + name + " : ");
            price = in.nextDouble();
            System.out.print("Enter quantity of " + name + " : ");
            quantity = in.nextDouble();
            Product newProduct = new Product(name, price, quantity);
            products.add(newProduct);
        } else {
            System.out.println("Product exists");
        }
    }

    void addProduct(String name, double price, double quantity) {
        Product newProduct = new Product(name, price, quantity);
        products.add(newProduct);
    }


    private Product search(String name) {
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

    void printProduct() {
        String name;
        Product foundProduct;

        System.out.print("Enter product name: ");
        name = in.next();
        foundProduct = search(name);
        if (foundProduct == null) {
            System.out.println("Product not found");
            return;
        }
        System.out.println(foundProduct.toString());
    }

    void printInventory() {
        double sum = 0;

        for (Product product : products) {
            System.out.println(product.toString());
            sum += product.getPrice() * product.getQuantity();
        }
        System.out.println("Sum of all products is: " + sum);
    }

    void printNamesProducts() {
        for (Product product : products) {
            System.out.print(product.getName() + ", ");
        }
    }
}