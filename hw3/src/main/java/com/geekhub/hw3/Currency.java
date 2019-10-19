package com.geekhub.hw3;

public enum Currency {
    USD(1),
    EURO(1.1),
    UAH(0.04);

    private double dollarRate;

    Currency(double dollarRate) {
        this.dollarRate = dollarRate;
    }

    public double getDollarRate() {
        return dollarRate;
    }
}
