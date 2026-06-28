package ru.aston.hometask3.strategy;

public class Test {
    public static void main(String[] args) {
        DiscountPercentage dp = new DiscountPercentage(0.2);
        DiscountAbsolute da = new DiscountAbsolute(30);

        Price price = new Price(500);
        price.applyDiscount(dp);
        price.applyDiscount(da);

        System.out.println((price.getOriginalPrice() == 500) + " " + price.getOriginalPrice());
        System.out.println((price.getActualPrice() == 370) + " " + price.getActualPrice());
    }
}
