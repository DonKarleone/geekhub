package com.geekhub.hw8.task1;

import com.geekhub.hw8.task1.repository.CustomerRepository;
import com.geekhub.hw8.task1.repository.OrderRepository;
import com.geekhub.hw8.task1.repository.ProductRepository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.UUID;

public class Application {
    public static void main(String[] args) throws SQLException {
        CustomerRepository customerRepository = new CustomerRepository();
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();

        Customer customer1 = new Customer(UUID.randomUUID(), "Taras", "Shevchenko", "380678888888");
        Customer customer2 = new Customer(UUID.randomUUID(), "Ivan", "Mazepa", "380677777777");
        Customer customer3 = new Customer(UUID.randomUUID(), "Ivan", "Franko", "380676666666");

        Product product1 = new Product(UUID.randomUUID(), "notebook", "MacBook15", new BigDecimal(45000));
        Product product2 = new Product(UUID.randomUUID(), "phone", "iPhone11", new BigDecimal(26000));
        Product product3 = new Product(UUID.randomUUID(), "phone", "iPhoneX", new BigDecimal(21000));
        Product product4 = new Product(UUID.randomUUID(), "tablet", "iPadPro", new BigDecimal(18000));
        Product product5 = new Product(UUID.randomUUID(), "phone", "Xiaomi", new BigDecimal(8000));

        Order order1 = new Order(UUID.randomUUID(), customer1, "Cherkasy, Hreschatik 10, ap.2", Arrays.asList(
                new OrderedProduct(product1, product1.getCurrentPrice(), 1),
                new OrderedProduct(product3, product3.getCurrentPrice(), 2),
                new OrderedProduct(product5, product5.getCurrentPrice(), 3)
        ));
        Order order2 = new Order(UUID.randomUUID(), customer2, "Kiyv, Hreschatik 23, ap.6", Arrays.asList(
                new OrderedProduct(product2, product2.getCurrentPrice(), 1),
                new OrderedProduct(product4, product4.getCurrentPrice(), 2),
                new OrderedProduct(product5, product5.getCurrentPrice(), 4)
        ));
        Order order3 = new Order(UUID.randomUUID(), customer3, "Lviv, Pl Rynok 5, ap.8", Arrays.asList(
                new OrderedProduct(product3, product3.getCurrentPrice(), 2),
                new OrderedProduct(product4, product4.getCurrentPrice(), 1),
                new OrderedProduct(product5, product5.getCurrentPrice(), 3)
        ));

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        System.out.println("Customers spend:");
        for (CustomerSpend customerSpend : customerRepository.getCustomersSpend()) {
            System.out.println(customerSpend);
        }
        System.out.print("\n Most popular product:");
        System.out.println(productRepository.getMostPopularProduct());

        orderRepository.delete(order1);
        orderRepository.delete(order2);
        orderRepository.delete(order3);

        productRepository.delete(product1);
        productRepository.delete(product2);
        productRepository.delete(product3);
        productRepository.delete(product4);
        productRepository.delete(product5);

        customerRepository.delete(customer1);
        customerRepository.delete(customer2);
        customerRepository.delete(customer3);
    }
}
