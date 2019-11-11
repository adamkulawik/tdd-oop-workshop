package pl.tdd.exercises.telldontask.useCase;

import pl.tdd.exercises.telldontask.domain.Order;
import pl.tdd.exercises.telldontask.domain.OrderStatus;
import pl.tdd.exercises.telldontask.repository.OrderRepository;
import pl.tdd.exercises.telldontask.service.ShipmentService;

import static pl.tdd.exercises.telldontask.domain.OrderStatus.*;

public class OrderShipmentUseCase {
    private final OrderRepository orderRepository;
    private final ShipmentService shipmentService;

    public OrderShipmentUseCase(OrderRepository orderRepository, ShipmentService shipmentService) {
        this.orderRepository = orderRepository;
        this.shipmentService = shipmentService;
    }

    public void run(OrderShipmentRequest request) {
        final Order order = orderRepository.getById(request.getOrderId());

        if (order.getStatus().equals(CREATED) || order.getStatus().equals(REJECTED)) {
            throw new OrderCannotBeShippedException();
        }

        if (order.getStatus().equals(SHIPPED)) {
            throw new OrderCannotBeShippedTwiceException();
        }

        shipmentService.ship(order);

        order.setStatus(OrderStatus.SHIPPED);
        orderRepository.save(order);
    }
}
