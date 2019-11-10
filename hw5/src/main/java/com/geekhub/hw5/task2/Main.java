package com.geekhub.hw5.task2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User [] users = new User [6];
        users[0] = (new User("Sheva", "25"));
        users[1] = (new User("Franko", "30"));
        users[2] = (new User("Orlik", "45"));
        users[3] = (new User("Mazepa", "45"));
        users[4] = (new User("Mazepa", "40"));
        users[5] = (new User("Mazepa", "25"));
        System.out.println("--- sortByBubbles ASC ---");
        System.out.println(Arrays.toString(ArraySorter.bubbleSort(users, Direction.ASC)));
        System.out.println("\n" + "--- sortByInsertion ASC ---");
        System.out.println(Arrays.toString(ArraySorter.insertionSort(users, Direction.ASC)));
        System.out.println("\n" + "--- sortBySelection ASC ---");
        System.out.println(Arrays.toString(ArraySorter.selectionSort(users, Direction.ASC)));
        System.out.println("\n" + "--- sortByBubbles DESC ---");
        System.out.println(Arrays.toString(ArraySorter.bubbleSort(users, Direction.DESC)));
        System.out.println("\n" + "--- sortByInsertion DESC ---");
        System.out.println(Arrays.toString(ArraySorter.insertionSort(users, Direction.DESC)));
        System.out.println("\n" + "--- sortBySelection DESC ---");
        System.out.println(Arrays.toString(ArraySorter.selectionSort(users, Direction.DESC)));
    }
}
