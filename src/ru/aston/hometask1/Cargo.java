package ru.aston.hometask1;

public final class Cargo {
    private final int length;
    private final int width;
    private final int height;
    private final Address destination;

    public Cargo(int length, int width, int height, Address address) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.destination = address.copy();
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

