package com.geekhub.hw3;

import java.util.ArrayList;
import java.util.List;

class Bank {

    private List<Customer> customers;

    Bank() {
        this.customers = new ArrayList<>();
    }

    List<Customer> getCustomers() {
        return customers;
    }

    void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    boolean addAsset(long taxId, Asset asset) {
        for (Customer customer : customers) {
            if (customer.getTaxId() == taxId) {
                customer.addAsset(asset);
                return true;
            }
        }
        return false;
    }

    Customer getCustomerByTaxId(long taxId) {
        for (Customer customer : customers) {
            if (customer.getTaxId() == taxId) {
                return customer;
            }
        }
        return null;
    }
}
