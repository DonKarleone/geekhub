package com.geekhub.hw8.task1;

import java.math.BigDecimal;

public class OrderedProduct {

    private Product product;
    private BigDecimal price;
    private int quantity;

    public OrderedProduct(Product product, BigDecimal price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderedProduct{" +
                "product=" + product +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
