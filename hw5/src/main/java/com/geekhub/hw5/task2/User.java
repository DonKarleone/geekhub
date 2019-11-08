package com.geekhub.hw5.task2;

public class User implements Comparable<User> {
    private final String name;
    private final int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        int result;
        result = name.compareTo(o.name);
        if (result != 0) {
            return result;
        }
        return Integer.compare(age, o.age);
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age='" + age + '\'' + '}';
    }
}
