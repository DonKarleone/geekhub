package com.geekhub.hw4.list;

import com.geekhub.hw4.list.linked.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        List<Person> people = new LinkedList<>();
        listSizeMustBe(people, 0);
        contentMustBe(people, "");
        indexOfElementMustBe(people, new Person("Joe"), -1);

        people.add(new Person("Joe"));
        listSizeMustBe(people, 1);
        contentMustBe(people, "Joe");
        indexOfElementMustBe(people, new Person("Joe"), 0);

        people.add(new Person("Johny"));
        listSizeMustBe(people, 2);
        contentMustBe(people, "JoeJohny");
        indexOfElementMustBe(people, new Person("Johny"), 1);

        List<Person> newPeople1 = new LinkedList<>();
        newPeople1.add(new Person("Jane"));
        newPeople1.add(new Person("Jim"));
        people.addAll(newPeople1);

        listSizeMustBe(people, 4);
        contentMustBe(people, "JoeJohnyJaneJim");
        indexOfElementMustBe(people, new Person("Jim"), 3);

        people.clear();
        listSizeMustBe(people, 0);
        contentMustBe(people, "");
        indexOfElementMustBe(people, new Person("Joe"), -1);
    }

    private static void listSizeMustBe(List<Person> list, int expectedSize) {
        if (list.size() != expectedSize) {
            String msg = String.format("List size must be %d but not %d", expectedSize, list.size());
            throw new RuntimeException(msg);
        }

        if (expectedSize == 0 && !list.isEmpty()) {
            throw new RuntimeException("List must be empty");
        }

        if (expectedSize > 0 && list.isEmpty()) {
            throw new RuntimeException("List must not be empty");
        }
    }

    private static void contentMustBe(List<Person> list, String expectedContent) {
        StringBuilder content = new StringBuilder();
        for (Object o : list) {
            content.append(o);
        }

        if (!expectedContent.equals(content.toString())) {
            String msg = String.format("Expected content: %s but not: %s", expectedContent, content.toString());
            throw new RuntimeException(msg);
        }
    }

    private static void indexOfElementMustBe(List<Person> list, Person element, int expectedIndex) {
        int index = list.indexOf(element);
        if (index != expectedIndex) {
            String msg = String.format("Expected index: %d but not: %d", expectedIndex, index);
            throw new RuntimeException(msg);
        }
    }
}
