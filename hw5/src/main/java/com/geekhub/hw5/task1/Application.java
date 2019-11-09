package com.geekhub.hw5.task1;

import java.util.Scanner;

public class Application {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Inventory inventory = new Inventory();
        inventory.addProduct("Apples", 15, 30);
        inventory.addProduct("Bananas", 28, 15);
        inventory.addProduct("Oranges", 32, 20);
        System.out.println(" \n Available products : ");
        inventory.printNamesProducts();
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
                    inventory.addProduct();
                    break;
                case "2":
                    inventory.printProduct();
                    break;
                case "3":
                    inventory.printInventory();
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
}
