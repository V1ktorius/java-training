package ru.aston.hometask3.decorator;

public class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", cheese";
    }
    @Override
    public double getCost() {
        return pizza.getCost() + 1.50;
    }
}
