package ru.aston.hometask3.chainOfResponsibility;

public class PaymentValidator extends Validator {
    @Override
    protected void check(Order order) {
        if (order.total() <= 0) {
            throw new IllegalArgumentException("Invalid total");
        }
    }
}
