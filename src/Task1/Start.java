package Task1;

public class Start {
    public static void main(String[] args) {
        Cargo cargo = new Cargo(5,2,2, new Address("Свердловская область","Екатеринбург","Ленина",20,30));
        System.out.println("Груз:\n" + cargo);

        Address address = cargo.getDestination()
                .setStreet("Советская")
                .setHouse(100)
                .setFlat(15);
        System.out.println("\nИзменённый адресс:\n" + address);
        System.out.println("\nГруз с неизменённым полем:\n" + cargo);
    }
}
