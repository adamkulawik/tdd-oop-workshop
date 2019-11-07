package pl.tdd.samples.encapsulation.correct;

class ChargingStation {

    private Address address;
    private Owner owner;

    void install(Address newAddress, Owner newOwner) {
        address = newAddress;
        owner = newOwner;
    }

    Address address() {
        return address;
    }

    Owner owner() {
        return owner;
    }
}
