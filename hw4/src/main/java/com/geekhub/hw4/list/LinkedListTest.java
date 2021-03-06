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

        people.add(new Person("Andy"));
        people.add(1, new Person("Alex"));
        people.add(0, new Person("Jim"));
        people.add(1, new Person("Lisa"));
        listSizeMustBe(people, 4);
        contentMustBe(people, "JimLisaAndyAlex");
        indexOfElementMustBe(people, new Person("Lisa"), 1);

        List<Person> p1 = new LinkedList<>();
        p1.add(new Person("Ruslan"));
        List<Person> p2 = new LinkedList<>();
        p2.add(new Person("Dima"));
        p2.add(new Person("Yura"));
        p1.addAll(0, p2);
        contentMustBe(p1, "DimaYuraRuslan");
        listSizeMustBe(p1, 3);

        List<Person> q1 = new LinkedList<>();
        q1.add(new Person("Ruslan"));
        List<Person> q2 = new LinkedList<>();
        q2.add(new Person("Dima"));
        q2.add(new Person("Yura"));
        q1.addAll(1, q2);
        contentMustBe(q1, "RuslanDimaYura");
        listSizeMustBe(q1, 3);

        List<Person> w1 = new LinkedList<>();
        w1.add(new Person("Ruslan"));
        w1.add(new Person("Joe"));
        List<Person> w2 = new LinkedList<>();
        w2.add(new Person("Dima"));
        w2.add(new Person("Yura"));
        w1.addAll(1, w2);
        contentMustBe(w1, "RuslanDimaYuraJoe");
        listSizeMustBe(w1, 4);

        List<Person> s1 = new LinkedList<>();
        s1.add(new Person("Jimmy"));
        s1.addAll(new LinkedList<>());
        s1.addAll(0, new LinkedList<>());
        contentMustBe(s1, "Jimmy");
        listSizeMustBe(s1, 1);

        List<Person> list = new LinkedList<>();
        list.add(new Person("Bob"));
        list.add(new Person("Bill"));
        list.add(new Person("Jimmy"));
        contentMustBe(list, "BobBillJimmy");
        listSizeMustBe(list, 3);
        list.remove(2);
        contentMustBe(list, "BobBill");
        listSizeMustBe(list, 2);

        list.add(new Person("Oruel"));
        contentMustBe(list, "BobBillOruel");
        listSizeMustBe(list, 3);
        list.remove(new Person("Bill"));
        contentMustBe(list, "BobOruel");
        listSizeMustBe(list, 2);

        list.add(new Person("Ivan"));
        Person person = list.remove(new Person("Bob"));
        elementMustBe(person, new Person("Bob"));
        person = list.remove(new Person("Stive"));
        elementMustBe(person, null);
        person = list.remove(1);
        elementMustBe(person, new Person("Ivan"));
        list = null;
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

    private static void elementMustBe(Person person, Person expectedPerson) {
        if (expectedPerson == null) {
            if (person != null) {
                throw new RuntimeException("Element must be empty");
            }
        } else if (!expectedPerson.equals(person)) {
            String msg = String.format("Element must be %s.", expectedPerson.toString());
            throw new RuntimeException(msg);
        }
    }
}
