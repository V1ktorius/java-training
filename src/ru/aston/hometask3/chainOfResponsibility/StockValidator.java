package ru.aston.hometask3.chainOfResponsibility;

public class StockValidator extends Validator {
    @Override
    protected void check(Order order) {
        if (!order.inStock()) {
            throw new IllegalArgumentException("Out of stock");
        }
    }
}
