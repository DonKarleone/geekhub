package com.geekhub.hw8.task1;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal currentPrice;

    public Product(UUID id, String name, String description, BigDecimal currentPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.currentPrice = currentPrice;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
