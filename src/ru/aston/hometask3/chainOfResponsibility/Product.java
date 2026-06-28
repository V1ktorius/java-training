package ru.aston.hometask3.chainOfResponsibility;

public final class Product implements Cloneable {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public Product clone() {
        return new Product(this.name, this.price);
    }
}
