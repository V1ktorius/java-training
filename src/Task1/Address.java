package Task1;

// изменяемый класс
public class Address {
    private String region;
    private String settlement;
    private String street;
    private int house;
    private int flat;

    Address(String region, String settlement, String street, int house, int flat) {
        this.region = region;
        this.settlement = settlement;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    protected String getRegion() {
        return region;
    }
    protected String getSettlement() {
        return settlement;
    }
    protected String getStreet() {
        return street;
    }
    protected int getHouse() {
        return house;
    }
    protected int getFlat() {
        return flat;
    }

    protected Address setRegion(String region) {
        this.region = region;
        return this;
    }
    protected Address setSettlement(String settlement) {
        this.settlement = settlement;
        return this;
    }
    protected Address setStreet(String street) {
        this.street = street;
        return this;
    }
    protected Address setHouse(int house) {
        this.house = house;
        return this;
    }
    protected Address setFlat(int flat) {
        this.flat = flat;
        return this;
    }

    protected Address copy() {
        return new Address(this.region, this.settlement, this.street, this.house, this.flat);
    }

    @Override
    public String toString() {
        return region + ", г. " + settlement + ", ул. " + street + ", д. " + house + ", кв. " + flat;
    }
}
