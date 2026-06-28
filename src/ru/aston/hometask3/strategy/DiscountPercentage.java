package ru.aston.hometask3.strategy;

public class DiscountPercentage implements IDiscountStrategy {
    private final double percent;

    public DiscountPercentage(double percent) {
        this.percent = percent;
    }

    @Override
    public double apply(double price) {
        return isApplicable(price) ? price * (1 - percent) : price;
    }
    @Override
    public Boolean isApplicable(double price) {
        return percent >= 0 && percent <= 1;
    }
}
