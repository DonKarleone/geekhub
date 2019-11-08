package com.geekhub.hw5.task2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Sheva", 25));
        users.add(new User("Franko", 30));
        users.add(new User("Orlik", 45));
        users.add(new User("Mazepa", 45));
        users.add(new User("Mazepa", 40));
        users.add(new User("Mazepa", 25));
        System.out.println("--- sortByBubbles ASC ---");
        System.out.println(ListSorter.sortByBubbles(users, Direction.ASC));
        System.out.println("\n" + "--- sortByInsertion ASC ---");
        System.out.println(ListSorter.sortByInsertion(users, Direction.ASC));
        System.out.println("\n" + "--- sortBySelection ASC ---");
        System.out.println(ListSorter.sortBySelection(users, Direction.ASC));
        System.out.println("\n" + "--- sortByBubbles DESC ---");
        System.out.println(ListSorter.sortByBubbles(users, Direction.DESC));
        System.out.println("\n" + "--- sortByInsertion DESC ---");
        System.out.println(ListSorter.sortByInsertion(users, Direction.DESC));
        System.out.println("\n" + "--- sortBySelection DESC ---");
        System.out.println(ListSorter.sortBySelection(users, Direction.DESC));
    }
}
