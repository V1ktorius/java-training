package ru.aston.hometask1;

import java.io.IOException;

public final class Cargo {
    private final int length;
    private final int width;
    private final int height;
    private final Address destination;

    public Cargo(int length, int width, int height, Address address) throws NullPointerException {
        if (address != null) {
            this.destination = address.clone();
        } else {
            throw new NullPointerException("Address is undefined");
        }
        this.length = length;
        this.width = width;
        this.height = height;
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
        return destination.clone();
    }

    @Override
    public String toString() {
        return "Габариты: " + length + "x" + width + "x" + height + "\n" +
            "Назначение: " + destination;
    }
}

