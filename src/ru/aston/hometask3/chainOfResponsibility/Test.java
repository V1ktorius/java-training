package ru.aston.hometask3.chainOfResponsibility;

public class Test {
    public static void main(String[] args) {
        Order order;
        Validator chain = new StockValidator();
        chain.setNext(new PaymentValidator());

        order = new Order();
        order.addProduct(new Product("11", 100.55), 2);
        order.addProduct(new Product("12", 225), 2);

        chain.validate(order);
        System.out.println("Test 1 completed successfully.");

        try {
            order = new Order();
            order.addProduct(new Product("21", -100.55), 2);

            chain.validate(order);
            System.out.println("Test 2 completed without expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals("Invalid total"))
                System.out.println("Test 2 completed successfully.");
            else
                System.out.println("Test 2 completed with expected exception but wrong message " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Test 2 completed with unexpected error " + e.getMessage());
        }

        try {
            order = new Order();
            order.addProduct(new Product("31", 100.55), 2);

            chain.validate(order);
            System.out.println("Test 3 completed without expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals("Out of stock"))
                System.out.println("Test 3 completed successfully.");
            else
                System.out.println("Test 4 completed with expected exception but wrong message " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Test 3 completed with unexpected error " + e.getMessage());
        }

        //Paymen
//        Product product1 = ;
//        Product product2 = ;
//        order.addProduct(new Product("2", 59.99), 5);
//        Product product3 = ;
//        order.addProduct(new Product("3", 220.2022), 10);
//        Product product4 = ;
//        order.addProduct(new Product("4", 333.3333), 0);


    }
}
