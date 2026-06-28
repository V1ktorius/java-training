package ru.aston.hometask3.strategy;

import java.util.ArrayList;
import java.util.List;

public class Price {
    private final double originalPrice;
    private double actualPrice;
    private List<IDiscountStrategy> discountHistory;

    Price(double price) {
        originalPrice = price;
        actualPrice = price;
        discountHistory = new ArrayList<>(5);
    }

    public double getOriginalPrice() {
        return originalPrice;
    }
    public double getActualPrice() {
        return actualPrice;
    }

    public Boolean applyDiscount(IDiscountStrategy strategy) {
        if (!strategy.isApplicable(actualPrice)) {
            return false;
        }

        actualPrice = strategy.apply(actualPrice);
        discountHistory.add(strategy);

        return true;
    }
}
