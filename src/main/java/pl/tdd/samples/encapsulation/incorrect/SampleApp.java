package pl.tdd.samples.encapsulation.incorrect;

public class SampleApp {

    public static void main(String[] args) {
        ChargingStation chargingStation = new ChargingStation();
        chargingStation.setOwner(new Owner());
        chargingStation.getOwner().setName("name");
    }
}

