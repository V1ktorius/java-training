package ru.aston.hometask3.chainOfResponsibility;

public class ProductOrder {
    private final Product product;
    private final int amount;

    public ProductOrder(Product product, int amount) {
        this.product = product.clone();
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
    public double getTotalPrice() {
        return product.getPrice() * amount;
    }
    public double getPrice() {
        return product.getPrice();
    }
    public String getName() {
        return product.getName();
    }
}
