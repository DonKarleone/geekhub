package com.geekhub.hw5.task1;

import java.util.Scanner;

public class Application {
    private static Scanner in = new Scanner(System.in);
    private static Inventory inventory = new Inventory();

    public static void main(String args[]) {
        inventory.addProduct("Apples", 15, 30);
        inventory.addProduct("Bananas", 28, 15);
        inventory.addProduct("Oranges", 32, 20);
        System.out.println(" \n Available products : ");
        printNamesProducts();
        String input;
        boolean exit = false;
        do {
            System.out.println();
            System.out.println("1) Add a new product ");
            System.out.println("2) View info product");
            System.out.println("3) Whole price of products ");
            System.out.println("4) Quit");
            System.out.println();
            System.out.print("Enter choice [1-4]: ");
            input = in.next();
            switch (input) {
                case "1":
                    add();
                    break;
                case "2":
                    infoProduct();
                    break;
                case "3":
                    printInventory();
                    break;
                case "4":
                    System.out.println("Good bye");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        while (!exit);
    }

    private static void add() {
        String name;
        double price;
        double quantity;
        System.out.print("Enter name of new product : ");
        name = in.next();
        if (inventory.search(name) == null) {
            System.out.print("Enter price for 1kg of " + name + " : ");
            price = in.nextDouble();
            System.out.print("Enter quantity of " + name + " : ");
            quantity = in.nextDouble();
            inventory.addProduct(name, price, quantity);
        } else {
            System.out.println("Product exists");
        }
    }

    private static void infoProduct() {
        String name;
        System.out.print("Enter product name: ");
        name = in.next();
        if (inventory.search(name) == null) {
            System.out.println("Product not found");
            return;
        }
        System.out.println(inventory.search(name).toString());
    }

    private static void printInventory() {
        inventory.products.stream().forEach(System.out::println);
        System.out.println("Sum of all products is: " + inventory.countSum());
    }

    private static void printNamesProducts() {
        for (Product product : inventory.products) {
            System.out.print(product.getName() + ", ");
        }
        System.out.println();
    }
}
