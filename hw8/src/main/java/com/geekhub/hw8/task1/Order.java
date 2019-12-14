package com.geekhub.hw8.task1;

import java.util.List;
import java.util.UUID;

public class Order {

    private UUID id;
    private Customer customer;
    private String deliveryPlace;
    private List<OrderedProduct> products;

    public Order(UUID id, Customer customer, String deliveryPlace, List<OrderedProduct> products) {
        this.id = id;
        this.customer = customer;
        this.deliveryPlace = deliveryPlace;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public List<OrderedProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderedProduct> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", deliveryPlace='" + deliveryPlace + '\'' +
                ", products=" + products +
                '}';
    }
}
