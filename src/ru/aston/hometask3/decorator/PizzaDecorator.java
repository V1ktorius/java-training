package ru.aston.hometask3.decorator;

public abstract class PizzaDecorator implements Pizza {
    protected final Pizza pizza;
    protected PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
    @Override
    public double getCost() {
        return pizza.getCost();
    }
}
