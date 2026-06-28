package ru.aston.hometask3.strategy;

public interface IDiscountStrategy {
    double apply(double price);
    Boolean isApplicable(double price);
}
