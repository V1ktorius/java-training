package ru.aston.hometask3.decorator;

public class PestoDecorator extends PizzaDecorator {
    public PestoDecorator(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", pesto sauce";
    }
    @Override
    public double getCost() {
        return pizza.getCost() + 0.50;
    }
}
