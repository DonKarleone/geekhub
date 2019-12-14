package com.geekhub.hw8.task1.repository;

import com.geekhub.hw8.task1.Order;
import com.geekhub.hw8.task1.OrderedProduct;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderRepository extends Repository {

    public boolean save(Order order) throws SQLException {
        String insertOrderSQL =
                "INSERT INTO \"order\"(id, customer, delivery_place) VALUES (?, ?, ?)" +
                "ON CONFLICT (id) DO UPDATE SET customer = ?, delivery_place = ?;";
        String insertOrderedProductSQL =
                "INSERT INTO product_in_order(product, \"order\", quantity, price) VALUES (?, ?, ?, ?)" +
                "ON CONFLICT (product, \"order\") DO UPDATE SET quantity = ?, price = ?;";
        String deleteExtraOrderedProductsSQL =
                "DELETE FROM product_in_order WHERE \"order\" = ? AND NOT (product = ANY (?))";

        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);
            try {
                PreparedStatement insertOrderStatement = connection.prepareStatement(insertOrderSQL);
                insertOrderStatement.setObject(1, order.getId());
                insertOrderStatement.setObject(2, order.getCustomer().getId());
                insertOrderStatement.setString(3, order.getDeliveryPlace());
                insertOrderStatement.setObject(4, order.getCustomer().getId());
                insertOrderStatement.setString(5, order.getDeliveryPlace());
                insertOrderStatement.executeUpdate();

                PreparedStatement insertOrderedProductStatement = connection.prepareStatement(insertOrderedProductSQL);
                for (OrderedProduct orderedProduct : order.getProducts()) {
                    insertOrderedProductStatement.setObject(1, orderedProduct.getProduct().getId());
                    insertOrderedProductStatement.setObject(2, order.getId());
                    insertOrderedProductStatement.setInt(3, orderedProduct.getQuantity());
                    insertOrderedProductStatement.setBigDecimal(4, orderedProduct.getPrice());
                    insertOrderedProductStatement.setInt(5, orderedProduct.getQuantity());
                    insertOrderedProductStatement.setBigDecimal(6, orderedProduct.getPrice());
                    insertOrderedProductStatement.addBatch();
                }
                insertOrderedProductStatement.executeBatch();

                PreparedStatement deleteExtraOrderedProductsStatement = connection.prepareStatement(deleteExtraOrderedProductsSQL);
                deleteExtraOrderedProductsStatement.setObject(1, order.getId());
                Array productsToKeep = connection.createArrayOf("UUID",
                        order.getProducts().stream().map(p -> p.getProduct().getId()).toArray());
                deleteExtraOrderedProductsStatement.setArray(2, productsToKeep);
                deleteExtraOrderedProductsStatement.executeUpdate();
            } catch (SQLException exception) {
                connection.rollback();
                throw exception;
            }
            connection.commit();
            return true;
        }
    }

    public boolean delete(Order order) throws SQLException {
        String deleteOrderSQL = "DELETE FROM \"order\" WHERE id = ?";
        String deleteOrderedProductsSQL = "DELETE FROM product_in_order WHERE \"order\" = ?";
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);
            try {
                PreparedStatement deleteOrderedProductsStatement = connection.prepareStatement(deleteOrderedProductsSQL);
                deleteOrderedProductsStatement.setObject(1, order.getId());
                deleteOrderedProductsStatement.executeUpdate();

                PreparedStatement deleteOrderStatement = connection.prepareStatement(deleteOrderSQL);
                deleteOrderStatement.setObject(1, order.getId());
                deleteOrderStatement.executeUpdate();
            } catch (SQLException exception) {
                connection.rollback();
                throw exception;
            }
            connection.commit();
            return true;
        }
    }
}
