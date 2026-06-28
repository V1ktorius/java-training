package ru.aston.hometask3.strategy;

public class DiscountAbsolute implements IDiscountStrategy {
    private final double amount;

    public DiscountAbsolute(double amount) {
        this.amount = amount;
    }

    @Override
    public double apply(double price) {
        return isApplicable(price) ? price - amount : price;
    }
    @Override
    public Boolean isApplicable(double price) {
        return price >= amount;
    }
}
