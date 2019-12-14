package com.geekhub.hw8.task1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Repository {
    protected Connection getConnection() throws SQLException {
        String DATABASE = "jdbc:postgresql://localhost:5433/hw811";
        String USERNAME = "postgres";
        String PASSWORD = "postgres";
        return DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
    }
}
