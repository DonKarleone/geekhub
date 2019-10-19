package com.geekhub.hw3;

import java.util.Scanner;

public class Application {

    private static Scanner in = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        bank.addCustomer(new Customer("Taras Shevchenko", 112233));
        bank.addAsset(112233, new CashAccount(Currency.UAH, 400000));
        bank.addCustomer(new Customer("Lesya Ukrainka", 445566));
        bank.addAsset(445566, new CashAccount(Currency.USD, 50000));
        bank.addAsset(445566, new Deposit(Currency.USD, 30000, 0.15, 5));
        bank.addCustomer(new LegalEntitie("Mersedes", 778899, 123456, 789012));
        bank.addAsset(778899, new PreciousMetals(MetalType.GOLD, 100));
        bank.addAsset(778899, new PreciousMetals(MetalType.PLATINUM, 50));
        bank.addCustomer(new LegalEntitie("Toyota", 115599, 987654, 321098));
        bank.addAsset(115599, new CashAccount(Currency.EURO, 5000000));
        bank.addAsset(115599, new PreciousMetals(MetalType.GOLD, 80));

        System.out.println("> list | add | info | total | quit");
        String command = "";
        while(!command.equals("quit")) {
            System.out.print(">> ");
            command = in.next();
            switch (command) {
                case "list":
                    list();
                    break;
                case "add":
                    add();
                    break;
                case "info":
                    info();
                    break;
                case "total":
                    total();
                    break;
                case "quit":
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    private static void list() {
        for (Customer customer : bank.getCustomers()) {
            System.out.println(customer.toString());
        }
    }

    private static void add() {
        System.out.println("> customer | asset | cancel");
        String whatToAdd = in.next();
        switch (whatToAdd) {
            case "customer":
                addCustomer();
                break;
            case "asset":
                addAsset();
            case "cancel":
                break;
            default:
                System.out.println("Unknown command.");
        }
    }

    private static void info() {
        System.out.println("Tax identification number:");
        long taxId = in.nextLong();
        Customer customer = bank.getCustomerByTaxId(taxId);
        if (customer == null) {
            System.out.println("The tax number you entered is not found.");
        } else {
            System.out.println(customer.toString());
            for (Asset asset : customer.getAssets()) {
                System.out.println("  " + asset.toString());
            }
            System.out.printf("Total value: %, .2f USD\n", customer.totalValue());
        }
    }

    private static void total() {
        double sum = 0;
        for (Customer customer : bank.getCustomers()) {
            sum += customer.totalValue();
        }
        System.out.printf("Total bank value: %, .2f USD\n", sum);
    }

    private static void addCustomer() {
        System.out.println("> individual | legal | cancel");
        String customerType = in.next();
        switch (customerType) {
            case "individual":
                addIndividualCustomer();
                break;
            case "legal":
                addLegalCustomer();
                break;
            case "cancel":
                break;
            default:
                System.out.println("Unknown command.");
        }
    }

    private static void addIndividualCustomer() {
        System.out.println("Name:");
        in.nextLine();
        String name = in.nextLine();
        System.out.println("Tax identification number:");
        long taxId = in.nextLong();
        if (bank.getCustomerByTaxId(taxId) != null) {
            System.out.println("The tax number you entered is already exists.");
        } else {
           bank.addCustomer(new Customer(name, taxId));
            System.out.println("Customer successfully added.");
        }
    }

    private static void addLegalCustomer() {
        System.out.println("Name:");
        in.nextLine();
        String name = in.nextLine();
        System.out.println("Tax identification number:");
        long taxId = in.nextLong();
        if (bank.getCustomerByTaxId(taxId) != null) {
            System.out.println("The tax number you entered is already exists.");
        } else {
            System.out.println("MFO Code:");
            long mfoCode = in.nextLong();
            System.out.println("EDRPOU Code:");
            long edrpouCode = in.nextLong();
            bank.addCustomer(new LegalEntitie(name, taxId, mfoCode, edrpouCode));
            System.out.println("Customer successfully added.");
        }
    }

    private static void addAsset() {
        System.out.println("> cash | metals | deposit | cancel");
        String customerType = in.next();
        switch (customerType) {
            case "cash":
                addCashAsset();
                break;
            case "metals":
                addMetalsAsset();
                break;
            case "deposit":
                addDepositAsset();
                break;
            case "cancel":
                break;
            default:
                System.out.println("Unknown command.");
        }
    }

    private static void addCashAsset() {
        System.out.println("Customer Tax ID:");
        long taxId = in.nextLong();
        System.out.println("Currency");
        Currency currency = inputEnum(Currency.class);
        System.out.println("Amount:");
        double amount = in.nextDouble();
        if (bank.addAsset(taxId, new CashAccount(currency, amount))) {
            System.out.println("Asset successfully added.");
        } else {
            System.out.println("The tax number you entered is not found.");
        }
    }

    private static void addMetalsAsset() {
        System.out.println("Customer Tax ID:");
        long taxId = in.nextLong();
        System.out.println("Metal");
        MetalType metalType = inputEnum(MetalType.class);
        System.out.println("Amount (kg):");
        double amount = in.nextDouble();
        if (bank.addAsset(taxId, new PreciousMetals(metalType, amount))) {
            System.out.println("Asset successfully added.");
        } else {
            System.out.println("The tax number you entered is not found.");
        }
    }

    private static void addDepositAsset() {
        System.out.println("Customer Tax ID:");
        long taxId = in.nextLong();
        System.out.println("Currency");
        Currency currency = inputEnum(Currency.class);
        System.out.println("Initial price:");
        double initialPrice = in.nextDouble();
        System.out.println("Percent:");
        double percent = in.nextDouble();
        System.out.println("Amount of years:");
        int amountOfYears = in.nextInt();
        if (bank.addAsset(taxId, new Deposit(currency, initialPrice, percent, amountOfYears))) {
            System.out.println("Asset successfully added.");
        } else {
            System.out.println("The tax number you entered is not found.");
        }
    }

    private static <E extends Enum<E>> E inputEnum(Class<E> enumeration) {
        while (true) {
            System.out.print(">");
            for (E e : enumeration.getEnumConstants()) {
                System.out.print(" " + e.name());
            }
            System.out.println();
            System.out.print(">> ");
            String userInput = in.next();
            for (E e : enumeration.getEnumConstants()) {
                if (e.name().compareToIgnoreCase(userInput) == 0) {
                    return e;
                }
            }
            System.out.println("Invalid value, try again.");
        }
    }
}

