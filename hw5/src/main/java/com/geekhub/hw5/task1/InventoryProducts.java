package com.geekhub.hw5.task1;

import java.util.Scanner;

public class InventoryProducts {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Inventory inventory = new Inventory();
        inventory.addProduct("Apples", 15, 30);
        inventory.addProduct("Bananas", 28, 15);
        inventory.addProduct("Oranges", 32, 20);
        System.out.println("Available products : ");
        inventory.printNamesProducts();
        int input = 1;
        do {
            System.out.println();
            System.out.println("1) Enter a new product ");
            System.out.println("2) View info product");
            System.out.println("3) Whole price of products ");
            System.out.println("4) Quit");
            System.out.println();
            System.out.print("Enter choice [1-4]: ");
            input = in.nextInt();
            switch (input) {
                case 1:
                    inventory.addProduct();
                    break;
                case 2:
                    inventory.printProduct();
                    break;
                case 3:
                    inventory.printInventory();
                    break;
                case 4:
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        while (input != 4);
    }
}
