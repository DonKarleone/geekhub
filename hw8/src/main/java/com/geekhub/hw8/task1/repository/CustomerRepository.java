package com.geekhub.hw8.task1.repository;

import com.geekhub.hw8.task1.Customer;
import com.geekhub.hw8.task1.CustomerSpend;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerRepository extends Repository {

    public boolean save(Customer customer) throws SQLException {
        String insertCustomerSQL =
                "INSERT INTO customer(id, first_name, last_name, cell_phone) VALUES (?, ?, ?, ?)" +
                "ON CONFLICT (id) DO UPDATE SET first_name = ?, last_name = ?, cell_phone = ?;";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(insertCustomerSQL)) {
            statement.setObject(1, customer.getId());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getCellPhone());
            statement.setString(5, customer.getFirstName());
            statement.setString(6, customer.getLastName());
            statement.setString(7, customer.getCellPhone());
            int updatedRows = statement.executeUpdate();
            return updatedRows > 0;
        }
    }

    public boolean delete(Customer customer) throws SQLException {
        String deleteCustomerSQL = "DELETE FROM customer WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteCustomerSQL)) {
            statement.setObject(1, customer.getId());
            int updatedRows = statement.executeUpdate();
            return updatedRows > 0;
        }
    }

    public List<CustomerSpend> getCustomersSpend() throws SQLException {
        String getCustomersSpendSQL =
                "SELECT c.*, SUM(pio.price) AS spend " +
                "FROM customer AS c " +
                "  JOIN \"order\" ON c.id = \"order\".customer " +
                "  JOIN product_in_order AS pio ON \"order\".id = pio.\"order\" " +
                "GROUP BY c.id;";
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getCustomersSpendSQL);
            List<CustomerSpend> customerSpends = new ArrayList<>();
            while (resultSet.next()) {
                Customer customer = new Customer(
                    (UUID) resultSet.getObject("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("cell_phone")
                );
                BigDecimal spend = resultSet.getBigDecimal("spend");
                customerSpends.add(new CustomerSpend(customer, spend));
            }
            return customerSpends;
        }
    }
}
