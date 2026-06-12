package Task1;

// неизменяемый класс с полем изменяемого класса
final class Cargo {
    final int length;
    final int width;
    final int height;
    private final Address destination;

    Cargo(int length, int width, int height, Address address) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.destination = address;
    }

    public int getLength() {
        return length;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Address getDestination() {
        return destination.copy();
    }

    @Override
    public String toString() {
        return "Габариты: " + length + "x" + width + "x" + height + "\n" +
            "Назначение: " + destination;
    }
}

