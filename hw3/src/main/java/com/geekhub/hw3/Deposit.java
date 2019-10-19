package com.geekhub.hw3;

public class Deposit implements Asset {

    private Currency currency;
    private double initialPrice;
    private double percent;
    private int amountOfYears;

    Deposit(Currency currency, double initialPrice, double percent, int amountOfYears) {
        this.currency = currency;
        this.initialPrice = initialPrice;
        this.percent = percent;
        this.amountOfYears = amountOfYears;
    }

    @Override
    public double totalPriceInUSD() {
        return (initialPrice + initialPrice * percent / 100 * amountOfYears) * currency.getDollarRate();
    }

    @Override
    public String toString() {
        return String.format("Deposit: %, .2f %s %.2f%% for %d years", initialPrice,
                currency.toString(), percent, amountOfYears);
    }
}
