package com.geekhub.hw8.task2;

import com.geekhub.hw8.task2.objects.Cat;
import com.geekhub.hw8.task2.objects.User;
import com.geekhub.hw8.task2.storage.DatabaseStorage;
import com.geekhub.hw8.task2.storage.Storage;
import com.zaxxer.hikari.HikariDataSource;

import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        HikariDataSource hikariDataSource = createHikariDataSource("postgres", "postgres", "postgres");
        Storage storage = new DatabaseStorage(hikariDataSource.getConnection());
        List<Cat> cats = storage.list(Cat.class);
        for (Cat cat : cats) {
            storage.delete(cat);
        }
        cats = storage.list(Cat.class);
        if (!cats.isEmpty()) throw new Exception("Cats should not be in database!");

        for (int i = 1; i <= 20; i++) {
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

        hikariDataSource.close();
    }

    private static HikariDataSource createHikariDataSource(String login, String password, String dbName) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5433/" + dbName);
        ds.setUsername(login);
        ds.setPassword(password);
        return ds;
    }
}
