package com.geekhub.hw8.task1;

import java.util.UUID;

public class Customer {

    private UUID id;
    private String firstName;
    private String lastName;
    private String cellPhone;

    public Customer(UUID id, String firstName, String lastName, String cellPhone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellPhone = cellPhone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                '}';
    }
}
