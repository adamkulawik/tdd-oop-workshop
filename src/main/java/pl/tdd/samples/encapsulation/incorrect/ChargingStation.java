package pl.tdd.samples.encapsulation.incorrect;

public class ChargingStation {
    private Owner owner;
    private Address address;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
