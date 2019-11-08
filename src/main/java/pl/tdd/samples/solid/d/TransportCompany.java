package pl.tdd.samples.solid.d;

public class TransportCompany {
    public void drive(Truck truck) {
        if(truck.isBroken()) {
            fix(truck);
        }
    }

    private void fix(Truck truck) {

    }
}

// add Mechanic, and delegate fix to it
// inject Mechanic via constructor
// inject Mechanic interface
// event