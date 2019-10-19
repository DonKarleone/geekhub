package com.geekhub.hw3;

public enum MetalType {
    GOLD(48000),
    SILVER(550),
    PLATINUM(28600);

    private double dollarRate;

    MetalType(double dollarRate) {
        this.dollarRate = dollarRate;
    }

    public double getDollarRate() {
        return dollarRate;
    }
}
