package ru.aston.hometask3.chainOfResponsibility;

import java.util.List;
import java.util.ArrayList;

public class Order {

    private final List<ProductOrder> products;

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product, int amount) {
        products.add(new ProductOrder(product, amount));
    }

    public double total() {
        return products.stream()
                .mapToDouble(ProductOrder::getTotalPrice)
                .sum();
    }

    // mocked for task purposes
    public final static int CAPACITY = 10;
    public Boolean inStock() {
        return products.stream().allMatch(productOrder -> productOrder.getAmount() < CAPACITY);
    }
}
