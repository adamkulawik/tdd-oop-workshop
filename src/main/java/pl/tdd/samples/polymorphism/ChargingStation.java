package pl.tdd.samples.polymorphism;

class ChargingStation {

    private final ChargingStationName chargingStationName;
    private Address address;
    private Owner owner;

    ChargingStation(ChargingStationName chargingStationName) {
        this.chargingStationName = chargingStationName;
    }

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
