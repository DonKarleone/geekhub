package com.geekhub.hw5.task2;

import java.util.ArrayList;
import java.util.List;

class ListSorter {

    static <T extends Comparable> List<T> sortByBubbles(List<T> elements, Direction direction) {
        List<T> sortedList = new ArrayList<>(elements);
        for (int sortTo = elements.size(); sortTo > 0; sortTo--) {
            for (int i = 0; i < sortTo - 1; i++) {
                if (sortedList.get(i).compareTo(sortedList.get(i + 1)) * direction.getDirection() > 0) {
                    T leftElement = sortedList.get(i);
                    sortedList.set(i, sortedList.get(i + 1));
                    sortedList.set(i + 1, leftElement);
                }
            }
        }
        return sortedList;
    }

    static <T extends Comparable> List<T> sortByInsertion(List<T> elements, Direction direction) {
        List<T> sortedList = new ArrayList<>();
        for (T element : elements) {
            int i = 0;
            while (i < sortedList.size() &&
                    sortedList.get(i).compareTo(element) * direction.getDirection() < 0) {
                i++;
            }
            sortedList.add(i, element);
        }
        return sortedList;
    }

    static <T extends Comparable> List<T> sortBySelection(List<T> elements, Direction direction) {
        List<T> sortedList = new ArrayList<>(elements);
        for (int i = 0; i < sortedList.size(); i++) {
            T elementToSwap = sortedList.get(i);
            int indexToSwap = i;
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(j).compareTo(elementToSwap) * direction.getDirection() < 0) {
                    elementToSwap = sortedList.get(j);
                    indexToSwap = j;
                }
            }
            sortedList.set(indexToSwap, sortedList.get(i));
            sortedList.set(i, elementToSwap);
        }
        return sortedList;
    }
}
