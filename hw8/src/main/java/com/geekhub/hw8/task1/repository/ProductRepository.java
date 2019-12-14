package com.geekhub.hw8.task1.repository;

import com.geekhub.hw8.task1.Product;

import java.sql.*;
import java.util.Optional;
import java.util.UUID;

public class ProductRepository extends Repository {

    public boolean save(Product product) throws SQLException {
        String insertProductSQL =
                "INSERT INTO product(id, name, description, current_price) VALUES (?, ?, ?, ?)" +
                "ON CONFLICT (id) DO UPDATE SET name = ?, description = ?, current_price = ?;";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(insertProductSQL)) {

            statement.setObject(1, product.getId());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDescription());
            statement.setBigDecimal(4, product.getCurrentPrice());
            statement.setString(5, product.getName());
            statement.setString(6, product.getDescription());
            statement.setBigDecimal(7, product.getCurrentPrice());

            int updatedRows = statement.executeUpdate();
            return updatedRows > 0;
        }
    }

    public boolean delete(Product product) throws SQLException {
        String deleteProductSQL = "DELETE FROM product WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteProductSQL)) {
            statement.setObject(1, product.getId());
            int updatedRows = statement.executeUpdate();
            return updatedRows > 0;
        }
    }

    public Optional<Product> getMostPopularProduct() throws SQLException {
        String getMostPopularProductSQL =
                "SELECT product.*, SUM(product_in_order.quantity) AS bought_total " +
                "FROM product_in_order " +
                "  JOIN product on product_in_order.product = product.id " +
                "GROUP BY product.id " +
                "ORDER BY bought_total DESC " +
                "LIMIT 1;";
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getMostPopularProductSQL);
            if (resultSet.next()) {
                System.out.println();
                return Optional.of(new Product(
                    (UUID) resultSet.getObject("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getBigDecimal("current_price")
                ));
            } else {
                return Optional.empty();
            }
        }
    }
}
