package com.geekhub.hw10.task2;

import java.util.HashMap;
import java.util.Map;

class UserService {
    private static final Map<String, User> users = new HashMap<String, User>();

    static {
        initUsers();
    }

    private static void initUsers() {
        User user1 = new User("user1", "1");
        User user2 = new User("user2", "2");
        User user3 = new User("user3", "3");
        users.put(user1.getName(), user1);
        users.put(user2.getName(), user2);
        users.put(user3.getName(), user3);
    }

    static String findUser(String userName, String password) {
        User user = users.get(userName);
        if (user != null && user.getPassword().equals(password)) {
            return userName;
        }
        return null;
    }
}
