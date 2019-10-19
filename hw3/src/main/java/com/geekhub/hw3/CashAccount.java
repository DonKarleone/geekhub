package com.geekhub.hw3;

public class CashAccount implements Asset {

    private Currency currency;
    private double amount;

    CashAccount(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public double totalPriceInUSD() {
        return amount * currency.getDollarRate();
    }

    @Override
    public String toString() {
        return String.format("Cash account: %, .2f %s", amount, currency.toString());
    }
}
