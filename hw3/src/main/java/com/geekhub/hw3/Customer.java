package com.geekhub.hw3;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private long taxId;
    private List<Asset> assets;

    Customer(String name, long taxId) {
        this.name = name;
        this.taxId = taxId;
        this.assets = new ArrayList<>();
    }

    long getTaxId() {
        return taxId;
    }

    List<Asset> getAssets() {
        return assets;
    }

    void addAsset(Asset asset) {
        assets.add(asset);
    }

    double totalValue() {
        double sum = 0;
        for (Asset asset : assets) {
            sum += asset.totalPriceInUSD();
        }
        return sum;
    }

    @Override
    public String toString() {
        return taxId + " " + name;
    }
}
