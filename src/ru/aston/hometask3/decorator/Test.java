package ru.aston.hometask3.decorator;

public class Test {
    public static void main(String[] args) {
        Pizza pizza1 = new PlainPizza();
        print(pizza1);

        Pizza pizza2 = new PepperoniDecorator(
                new CheeseDecorator(
                        new PlainPizza()
                )
        );
        print(pizza2);

        Pizza pizza3 = new PestoDecorator(
            new PepperoniDecorator(
                new ChickenDecorator(
                    new CheeseDecorator(
                        new PlainPizza()
                    )
                )
            )
        );
        print(pizza3);
    }

    static void print(Pizza pizza) {
        System.out.printf("%s -> $%.2f%n", pizza.getDescription(), pizza.getCost());
    }
}
