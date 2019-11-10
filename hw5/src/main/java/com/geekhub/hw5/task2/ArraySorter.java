package com.geekhub.hw5.task2;

import java.util.Arrays;

public class ArraySorter {
    public static <T extends Comparable<T>> T[] bubbleSort(T[] array, Direction direction) {
        T[] sortedArray = Arrays.copyOf(array, array.length);
        for (int sortTo = array.length - 1; sortTo > 0; sortTo--) {
            for (int i = 0; i < sortTo; i++) {
                if (sortedArray[i].compareTo(sortedArray[i + 1]) * direction.getDirection() > 0) {
                    T leftElement = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = leftElement;
                }
            }
        }
        return sortedArray;
    }

    public static <T extends Comparable<T>> T[] insertionSort(T[] array, Direction direction) {
        T[] sortedArray = Arrays.copyOf(array, array.length);
        int j;
        for (int i = 0; i < sortedArray.length; i++) {
            T buf = sortedArray[i];
            for (j = i - 1; j >= 0 && (sortedArray[j].compareTo(buf) * direction.getDirection()) >
                    (buf.compareTo(sortedArray[j]) * direction.getDirection()); j--) {
                sortedArray[j + 1] = sortedArray[j];
            }
            sortedArray[j + 1] = buf;
        }
        return sortedArray;
    }

    public static <T extends Comparable<T>> T[] selectionSort(T[] array, Direction direction) {
        T[] sortedArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < sortedArray.length; i++) {
            T elementToSwap = sortedArray[i];
            int indexToSwap = i;
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j].compareTo(elementToSwap) * direction.getDirection() < 0) {
                    elementToSwap = sortedArray[j];
                    indexToSwap = j;
                }
            }
            sortedArray[indexToSwap] = sortedArray[i];
            sortedArray[i] = elementToSwap;
        }
        return sortedArray;
    }
}
