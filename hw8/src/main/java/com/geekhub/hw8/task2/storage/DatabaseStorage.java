package com.geekhub.hw8.task2.storage;

import com.geekhub.hw8.task2.objects.Entity;
import com.geekhub.hw8.task2.objects.Ignore;
import com.geekhub.hw8.task2.objects.Users;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * Implementation of {@link Storage} that uses database as a storage for objects.
 * It uses simple object type names to define target table to save the object.
 * It uses reflection to access objects fields and retrieve data to map to database tables.
 * As an identifier it uses field id of {@link Entity} class.
 * Could be created only with {@link Connection} specified.
 */
public class DatabaseStorage implements Storage {
    private Connection connection;

    public DatabaseStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T extends Entity> T get(Class<T> clazz, Integer id) throws Exception {
        //this method is fully implemented, no need to do anything, it's just an example
        String sql;
        sql = "SELECT * FROM \"" + clazz.getSimpleName().toLowerCase() + "\" WHERE id = " + id;
        try (Statement statement = connection.createStatement()) {
            List<T> result = extractResult(clazz, statement.executeQuery(sql));
            return result.isEmpty() ? null : result.get(0);
        }
    }

    @Override
    public <T extends Entity> List<T> list(Class<T> clazz) throws Exception {
        String sql;
        sql = "SELECT * FROM \"" + clazz.getSimpleName().toLowerCase() + "\"";
        try (Statement statement = connection.createStatement()) {
            return extractResult(clazz, statement.executeQuery(sql));
        }
    }

    @Override
    public <T extends Entity> boolean delete(T entity) throws Exception {
        if (entity.isNew()) {
            return true;
        }
        String sql;
        sql = "DELETE FROM \"" + entity.getClass().getSimpleName().toLowerCase() + "\" WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public <T extends Entity> void save(T entity) throws Exception {
        if (entity.isNew()) {
            saveNewObject(entity);
        }
        updateObject(entity);
    }

    private <T extends Entity> void saveNewObject(T entity) throws Exception {
        Map<String, Object> preparedEntity = prepareEntity(entity);
        String tableName = entity.getClass().getSimpleName().toLowerCase();
        List<String> columnNames = new ArrayList<>(preparedEntity.keySet());
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("INSERT INTO \"");
        sqlStringBuilder.append(tableName);
        sqlStringBuilder.append("\"(\"");
        sqlStringBuilder.append(String.join("\", \"", columnNames));
        sqlStringBuilder.append("\") VALUES (");
        sqlStringBuilder.append(String.join(", ", Collections.nCopies(columnNames.size(), "?")));
        sqlStringBuilder.append(");");
        String sql = sqlStringBuilder.toString();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < columnNames.size(); i++) {
                preparedStatement.setObject(1 + i, preparedEntity.get(columnNames.get(i)));
            }
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                entity.setId(resultSet.getInt(1));
            }
        }
    }

    private <T extends Entity> void updateObject(T entity) throws Exception {
        Map<String, Object> preparedEntity = prepareEntity(entity);
        String tableName = entity.getClass().getSimpleName().toLowerCase();
        List<String> columnNames = new ArrayList<>(preparedEntity.keySet());
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("UPDATE \"");
        sqlStringBuilder.append(tableName);
        sqlStringBuilder.append("\" SET ");
        sqlStringBuilder.append(String.join(" = ?, ", columnNames));
        sqlStringBuilder.append(" = ? WHERE id = ?;");
        String sql = sqlStringBuilder.toString();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < columnNames.size(); i++) {
                preparedStatement.setObject(1 + i, preparedEntity.get(columnNames.get(i)));
            }
            preparedStatement.setInt(columnNames.size() + 1, entity.getId());
            preparedStatement.executeUpdate();
        }
    }

    //converts object to map, could be helpful in save method
    private <T extends Entity> Map<String, Object> prepareEntity(T entity) throws Exception {
        Map<String, Object> data = new HashMap<>();
        for (Field field : entity.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Ignore.class)) continue;
            field.setAccessible(true);
            data.put(field.getName(), field.get(entity));
        }
        return data;
    }

    //creates list of new instances of clazz by using data from resultset
    private <T extends Entity> List<T> extractResult(Class<T> clazz, ResultSet resultSet) throws Exception {
        List<T> resultList = new ArrayList<>();
        while (resultSet.next()) {
            T objectInstance = clazz.getConstructor().newInstance();
            objectInstance.setId(resultSet.getInt("id"));
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Ignore.class)) {
                    continue;
                }
                field.setAccessible(true);
                String fieldName = field.getName().toLowerCase();
                Object fieldValue = resultSet.getObject(fieldName);
                field.set(objectInstance, fieldValue);

                field.setAccessible(false);
            }
            resultList.add(objectInstance);
        }
        return resultList;
    }
}
