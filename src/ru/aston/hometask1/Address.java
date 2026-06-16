package ru.aston.hometask1;

public class Address implements Cloneable {
    private String region;
    private String settlement;
    private String street;
    private int house;
    private int flat;

    public Address(String region, String settlement, String street, int house, int flat) {
        this.region = region;
        this.settlement = settlement;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getRegion() {
        return region;
    }
    public String getSettlement() {
        return settlement;
    }
    public String getStreet() {
        return street;
    }
    public int getHouse() {
        return house;
    }
    public int getFlat() {
        return flat;
    }

    public Address setRegion(String region) {
        this.region = region;
        return this;
    }
    public Address setSettlement(String settlement) {
        this.settlement = settlement;
        return this;
    }
    public Address setStreet(String street) {
        this.street = street;
        return this;
    }
    public Address setHouse(int house) {
        this.house = house;
        return this;
    }
    public Address setFlat(int flat) {
        this.flat = flat;
        return this;
    }

    @Override
    public Address clone() {
        return new Address(this.region, this.settlement, this.street, this.house, this.flat);
    }

    @Override
    public String toString() {
        return region + ", г. " + settlement + ", ул. " + street + ", д. " + house + ", кв. " + flat;
    }
}
