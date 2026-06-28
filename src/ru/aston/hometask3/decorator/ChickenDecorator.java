package ru.aston.hometask3.decorator;

public class ChickenDecorator extends PizzaDecorator {
    public ChickenDecorator(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", chicken";
    }
    @Override
    public double getCost() {
        return pizza.getCost() + 2.50;
    }
}
