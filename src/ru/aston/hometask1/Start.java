package ru.aston.hometask1;

public class Start {
    public static void main(String[] args) {
        Address address1 = new Address("Свердловская область","Екатеринбург","Ленина",20,30);
        Cargo cargo = new Cargo(5,2,2, address1);
        System.out.println("Груз 1:\n" + cargo);

        address1.setStreet("Карла Маркса")
                .setHouse(52)
                .setFlat(36);
        System.out.println("\nИзменённый адресс 1:\n" + address1);
        System.out.println("\nГруз 2:\n" + cargo);

        Address address2 = cargo.getDestination()
                .setStreet("Советская")
                .setHouse(100)
                .setFlat(15);
        System.out.println("\nИзменённый адресс 2:\n" + address2);
        System.out.println("\nГруз 3:\n" + cargo);
    }
}
