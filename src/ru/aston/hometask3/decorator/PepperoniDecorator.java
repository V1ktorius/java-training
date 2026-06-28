package ru.aston.hometask3.decorator;

public class PepperoniDecorator extends PizzaDecorator {
    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", pepperoni";
    }
    @Override
    public double getCost() {
        return pizza.getCost() + 2.00;
    }
}
