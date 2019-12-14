package com.geekhub.hw8.task2;

import com.geekhub.hw8.task2.objects.Cat;
import com.geekhub.hw8.task2.objects.User;
import com.geekhub.hw8.task2.storage.DatabaseStorage;
import com.geekhub.hw8.task2.storage.Storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Test {
    private static final String DATABASE = "jdbc:postgresql://localhost:5433/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) throws Exception {
        Connection connection = createConnection(LOGIN, PASSWORD, DATABASE);

        Storage storage = new DatabaseStorage(connection);
        List<Cat> cats = storage.list(Cat.class);
        for (Cat cat : cats) {
            storage.delete(cat);
        }
        cats = storage.list(Cat.class);
        if (!cats.isEmpty()) throw new Exception("Cats should not be in database!");

        for(int i = 1; i <= 20; i++) {
            Cat cat = new Cat();
            cat.setName("cat" + i);
            cat.setAge(i);
            storage.save(cat);
        }

        cats = storage.list(Cat.class);
        if (cats.size() != 20) throw new Exception("Number of cats in storage should be 20!");

        User user = new User();
        user.setAdmin(true);
        user.setAge(23);
        user.setName("Victor");
        user.setBalance(22.23);
        storage.save(user);

        User user1 = storage.get(User.class, user.getId());
        if (!user1.getName().equals(user.getName())) throw new Exception("Users should be equals!");

        user.setAdmin(false);
        storage.save(user);

        User user2 = storage.get(User.class, user.getId());
        if (!user.getAdmin().equals(user2.getAdmin())) throw new Exception("Users should be updated!");

        storage.delete(user1);

        User user3 = storage.get(User.class, user.getId());

        if (user3 != null) throw new Exception("User should be deleted!");

        connection.close();
    }

    private static Connection createConnection(String login, String password, String dbName) throws Exception {
            return DriverManager.getConnection(dbName, login, password);
    }
}
