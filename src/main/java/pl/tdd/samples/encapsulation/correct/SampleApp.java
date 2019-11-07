package pl.tdd.samples.encapsulation.correct;

public class SampleApp {
    public static void main(String[] args) {
        ChargingStation station = new ChargingStation();
        Address address = new Address("address");
        Owner owner = new Owner("owner");
        station.install(address, owner);
    }
}
