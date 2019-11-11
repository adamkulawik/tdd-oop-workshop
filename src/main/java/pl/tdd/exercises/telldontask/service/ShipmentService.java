package pl.tdd.exercises.telldontask.service;

import pl.tdd.exercises.telldontask.domain.Order;

public interface ShipmentService {
    void ship(Order order);
}
