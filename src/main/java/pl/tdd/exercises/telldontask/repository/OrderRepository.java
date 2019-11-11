package pl.tdd.exercises.telldontask.repository;

import pl.tdd.exercises.telldontask.domain.Order;

public interface OrderRepository {
    void save(Order order);

    Order getById(int orderId);
}
