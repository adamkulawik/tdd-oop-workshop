package pl.tdd.samples.cohesion;

import java.time.LocalDate;

public class Car {

    private final VIN vin;
    private final Brand brand;
    private final Model model;
    private final Engine engine;
    private final GearBox gearBox;
    private Owner owner;
    private Registration registration;
    private LocalDate registrationDate;
    private Color color;
    private Integer rpm;
    private Integer speed;

    public Car(VIN vin, Brand brand, Model model, Engine engine, GearBox gearBox, Integer rpm, Integer speed, Integer gear) {
        this.vin = vin;
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.gearBox = gearBox;
        this.rpm = rpm;
        this.speed = speed;
    }

    public void changeOwner(Owner newOwner, Registration newRegistration, LocalDate newRegistrationDate) {
        registrationDate = newRegistrationDate;
        owner = newOwner;
        registration = newRegistration;
    }

    public void changeRegistration(Registration newRegistration, LocalDate newRegistrationDate) {
        registrationDate = newRegistrationDate;
        registration = newRegistration;
    }

    public void changeOwner(Owner newOwner) {
        owner = newOwner;
    }

    public void repaint(Color newColor) {
        color = newColor;
    }

    public void throttle(Throttle throttle) {
        rpm = engine.withThrottle(throttle);
        speed = gearBox.withRpm(rpm);
    }

}
