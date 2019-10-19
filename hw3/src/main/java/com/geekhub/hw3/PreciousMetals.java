package com.geekhub.hw3;

public class PreciousMetals implements Asset{

    private MetalType metalType;
    private double amount;

    PreciousMetals(MetalType metalType, double amount) {
        this.metalType = metalType;
        this.amount = amount;
    }

    @Override
    public double totalPriceInUSD() {
        return amount * metalType.getDollarRate();
    }

    @Override
    public String toString() {
        return String.format("Precious metal: %s, %.2f kg.", metalType.toString(), amount);
    }
}
