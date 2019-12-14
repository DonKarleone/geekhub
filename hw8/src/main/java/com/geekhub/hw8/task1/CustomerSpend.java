package com.geekhub.hw8.task1;

import java.math.BigDecimal;

public class CustomerSpend {

    private Customer customer;
    private BigDecimal spend;

    public CustomerSpend(Customer customer, BigDecimal spend) {
        this.customer = customer;
        this.spend = spend;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BigDecimal getSpend() {
        return spend;
    }

    @Override
    public String toString() {
        return "CustomerSpend{" +
                "customer=" + customer +
                ", spend=" + spend +
                '}';
    }
}
